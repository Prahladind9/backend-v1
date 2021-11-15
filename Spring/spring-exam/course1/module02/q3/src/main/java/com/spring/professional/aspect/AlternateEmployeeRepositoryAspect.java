package com.spring.professional.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AlternateEmployeeRepositoryAspect {
    @Before("execution(* com.spring.professional.service.b.AlternateEmployeeRepository.findEmployeeById(..))")
    public void beforeFindEmployeeId(){
        System.out.println("Service B - beforeFindEmployeeById");
    }

    @After("within(com.spring.professional.service.b.*)")
    public void afterExecutionWithinPackage(){
        System.out.println("Service B - afterExecutionWithinPackage");
    }
}
