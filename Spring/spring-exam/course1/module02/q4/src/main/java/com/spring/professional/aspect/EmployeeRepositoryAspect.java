package com.spring.professional.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class EmployeeRepositoryAspect {
    @Pointcut("within(com.spring.professional.service.*.*) || " +
            "within(com.spring.professional.*)")
    public void serviceOrSamePackageRepository(){

    }

    @Before("serviceOrSamePackageRepository()")
    public void before(JoinPoint joinPoint){
        System.out.println("before - " + joinPoint.getSignature());
    }

    @Before("serviceOrSamePackageRepository()")
    public void after(JoinPoint joinPoint){
        System.out.println("after - " + joinPoint.getSignature());
    }
}
