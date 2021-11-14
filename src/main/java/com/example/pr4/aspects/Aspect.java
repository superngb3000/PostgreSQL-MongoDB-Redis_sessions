package com.example.pr4.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("within(com.example.pr4.services.*)")
    public void allServiceMethods(){}

    @Around("allServiceMethods()")
    public Object timeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object res = proceedingJoinPoint.proceed();
        long finishTime = System.currentTimeMillis();
        log.info("Method "+ proceedingJoinPoint.getSignature().getName()
                + " in " + proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName()
                + " worked for " + (finishTime - startTime) + " ms");
        return res;
    }
}

//    @Before("allServiceMethods()")
//    public void logParameters(JoinPoint joinPoint) {
//        log.info("Parameters: " + Arrays.toString(joinPoint.getArgs()));
//    }