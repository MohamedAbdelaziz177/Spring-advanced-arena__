package com.abdelaziz26.aop.Aspects;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.abdelaziz26.aop.Annotations.AbdelazizValidator;

import java.util.Set;

@Component
@Aspect
@RequiredArgsConstructor
public class ValidatorAspect {

    private final Validator validator;

    @Pointcut("@annotation(com.abdelaziz26.aop.Annotations.AbdelazizValidator)")
    public void abdelazizValidator() {}

    @Before("abdelazizValidator()")
    public void validate(JoinPoint joinPoint) throws Throwable {

        for(Object arg : joinPoint.getArgs()) {

            if(arg != null) {

                Set<ConstraintViolation<Object>> violations = validator.validate(arg);

                StringBuilder sb = new StringBuilder();
                for (ConstraintViolation<Object> violation : violations) {
                    sb.append(violation.getPropertyPath().toString());
                    sb.append(": ");
                    sb.append(violation.getMessage());
                    sb.append("\n");
                }

                if(!sb.isEmpty()) {
                    throw new IllegalArgumentException(sb.toString());
                }

            }
        }
    }
}
