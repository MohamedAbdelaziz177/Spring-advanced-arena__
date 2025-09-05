package com.abdelaziz26.aop.Aspects;

import com.abdelaziz26.aop.Annotations.EnsureHeIsAbdelaziz;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;

@Aspect
@Component
public class EnsureAbdelazizAspect {

    @Pointcut("@annotation(com.abdelaziz26.aop.Annotations.EnsureHeIsAbdelaziz)")
    private void ensureHeIsAbdelaziz() {}

    @Before("ensureHeIsAbdelaziz()")
    public void ensureHeIsAbdelaziz(JoinPoint joinPoint){

        Object[] args = joinPoint.getArgs();

        if(args[0] == null) {
            throw new IllegalArgumentException("Username is null");
        }

        if(!args[0].toString().equals("_Abdelaziz26")) {
            throw new RuntimeException("You are Not Abdelaziz :(");
        }
    }
}
