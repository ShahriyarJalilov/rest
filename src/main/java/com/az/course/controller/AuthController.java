package com.az.course.controller;

import com.az.course.entity.User;
import com.az.course.exception.BadCredentialsException;
import com.az.course.exception.EmployeeNotFoundException;
import com.az.course.exception.UserNotFoundException;
import com.az.course.model.consts.SuccessMessage;
import com.az.course.model.request.TokenRequest;
import com.az.course.model.response.TokenResponse;
import com.az.course.service.EmployeeService;
import com.az.course.util.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

import static com.az.course.model.consts.SuccessMessage.SUCCESS_MESSAGE;
@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthController {

    private final EmployeeService employeeService;
    private final JwtToken jwtToken;
    private final AuthenticationManager authenticationManager;
    //v2.1
    @PostMapping("/token")
    public TokenResponse tokenResponse(@RequestBody TokenRequest request) {
        TokenResponse response = new TokenResponse(
                SUCCESS_MESSAGE.getCode(),
                SUCCESS_MESSAGE.getMessage()
        );
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        );
        try {

            authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException();
        }
        String token = jwtToken.generateToken(request.getUsername());
        response.setToken(token);
        return response;
    }

    @PostMapping("/refreshToken")
    @ResponseBody

    public  TokenResponse refreshToken(@RequestHeader ("Authorization") String token){
        TokenResponse response = new TokenResponse(
                200,
                SUCCESS_MESSAGE.getMessage()
        );
        response.setToken(jwtToken.refreshToken(token));
        return response;
    }



}
