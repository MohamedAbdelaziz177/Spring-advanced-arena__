package com.abdelaziz26.aop.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    private final static Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("@annotation(com.abdelaziz26.aop.Annotations.AbdelazizLogger)")
    private void abdelazizLogger() {}

    @Around("abdelazizLogger()")
    public Object executeLogging(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();

        LocalDateTime beforeExecution = LocalDateTime.now();

        logger.info("{} {} started processing at: {}", methodName, Arrays.toString(args), beforeExecution);

        Object result = joinPoint.proceed();

        LocalDateTime afterExecution = LocalDateTime.now();

        logger.info("{} finished processing successfully at: {}", methodName, afterExecution);

        return result;

    }
}
