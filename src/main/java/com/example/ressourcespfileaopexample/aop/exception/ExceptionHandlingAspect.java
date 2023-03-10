package com.example.ressourcespfileaopexample.aop.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {


    @AfterThrowing(pointcut = "execution(* com.example.ressourcespfileaopexample.aop.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        log.error("Exception thrown from method {} with message - {}", methodName, ex.getMessage());
    }
}