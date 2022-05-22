package com.az.course.filter;

import com.az.course.exception.AccessTokenExpired;
import com.az.course.exception.InvalidJwtTokenException;
import com.az.course.exception.TokenIsEmptyException;
import com.az.course.model.Status;
import com.az.course.util.JwtToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.az.course.model.consts.ErrorMessage.*;
import static org.springframework.http.HttpStatus.*;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtToken jwtToken;
    private final UserDetailsService userDetailsService;
    private final Status status = new Status();
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = "Authorization";
        final String requestHeader = request.getHeader(header);
        String username = null;
        String token = null;

        System.out.println(request.getRequestURI() + " ----");
        try {
            if (requestHeader != null && requestHeader.startsWith("Bearer ")
                    || request.getRequestURI().endsWith("token")
                    || request.getRequestURI().endsWith("refreshToken")) {
              boolean hasRole =  !request.getRequestURI().endsWith("token") &&!request.getRequestURI().endsWith("refreshToken");
              if(hasRole) {
                  assert requestHeader != null;
                  token = requestHeader.substring(7);
                  try {
                      username = jwtToken.getUsernameFromToken(token);
                      System.out.println("username" + username);
                  } catch (MalformedJwtException ex) {
                      logger.error("an error occurred during getting username from token", ex);
                      throw new InvalidJwtTokenException();
                  } catch (ExpiredJwtException ex) {
                      logger.error("the token is expired", ex);
                      throw new AccessTokenExpired();
                  }
              }
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (jwtToken.validateToken(token, userDetails)) {
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities()
                        );
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
                doFilter(request, response, filterChain);
            } else {
                throw new TokenIsEmptyException();
            }
        } catch (RuntimeException ex) {
            if (ex instanceof TokenIsEmptyException) {
                this.status.setCode(BAD_REQUEST.value());
                this.status.setMessage(TOKEN_IS_EMPTY.getMessage());
            } else if (ex instanceof SignatureException) {
                this.status.setCode(FORBIDDEN.value());
                this.status.setMessage(INVALID_TOKEN.getMessage());
            }else if(ex instanceof AccessTokenExpired){
                this.status.setCode(FORBIDDEN.value());
                this.status.setMessage(TOKEN_EXPIRED.getMessage());
            }
            else {
                this.status.setCode(INTERNAL_SERVER_ERROR.value());
                this.status.setMessage(INTERNAL_SERVER_ERROR.getReasonPhrase());
            }

            response.setContentType("application/json");
            response.setStatus(INTERNAL_SERVER_ERROR.value());
            response.getWriter().write(convertObjectToJson(this.status));
        }
    }

    //create response json
    public String convertObjectToJson(Object object) throws JsonProcessingException {
        Optional<Object> opt = Optional.ofNullable(object);
        if (!opt.isPresent()) return null;
        return objectMapper.writeValueAsString(object);
    }
}
