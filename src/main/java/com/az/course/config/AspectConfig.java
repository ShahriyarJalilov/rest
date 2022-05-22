package com.az.course.config;

import com.az.course.model.dto.EmployeeResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class AspectConfig {
//    @Before("employeeControl()")
//    public void logBefore(){
//        System.out.println("start____");
//    }
//    @After("execution( public * com.az.course.controller.RestControllers.employee(*))")
//    public void logAfter(){
//        System.out.println("end____");
//    }
//    @AfterReturning(pointcut = "@annotation(com.az.course.util.LogAspect)",returning = "employeeResponse")
//    public void logAfter(JoinPoint joinPoint, EmployeeResponse employeeResponse){
//        System.out.println("end method");
//        System.out.println("employee: "+ employeeResponse);
//        System.out.println(joinPoint);
//    }
////    @AfterThrowing(pointcut = "@annotation(com.az.course.util.LogAspect)",throwing = "ex")
////    public void logAfter(JoinPoint joinPoint,NullPointerException ex){
////        System.out.println(joinPoint);
////    }
//
//
//    @Pointcut("execution( public * com.az.course.controller.RestControllers.employee(*))")
//    public void employeeControl(){
//
//    }
//    @Around("employeeControl()")
//    public void around(ProceedingJoinPoint point){
//        try {
//            long startTime = System.currentTimeMillis();
//            EmployeeResponse response = (EmployeeResponse) point.proceed();
//            System.out.println(response);
//            System.out.println("execution time: "+(System.currentTimeMillis()-startTime));
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Pointcut("@annotation(com.az.course.util.LogAspect)")
//    public void annotation(){
//
//    }



}
