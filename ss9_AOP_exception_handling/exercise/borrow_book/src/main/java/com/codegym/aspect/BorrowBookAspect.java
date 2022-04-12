package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class BorrowBookAspect {
    @AfterReturning(pointcut = "execution(public * com.codegym.controller.BorrowBookController.create(..))||" +
            "execution(public * com.codegym.controller.BorrowBookController.returnBook(..))")

    public void logUpdateBook(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Method name: " + methodName);
        System.err.println("Args: " + args);
    }

    //    @AfterReturning(pointcut = "within(com.codegym.controller.BorrowBookController.*)")
    @AfterReturning(pointcut = "execution(public * com.codegym.controller.BorrowBookController.*(..))")
    public void logController(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.err.println("Method name: " + methodName);
        System.err.println("Args: " + args);
    }
}
