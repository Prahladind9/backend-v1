package com.spring.professional.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeRepositoryAspect {

    @Before("execution(* com.spring.professional.service.a.EmployeeRepository.findEmployeeById(..))")
    public void beforeFindEmployeeById(){
        System.out.println("Service A - beforeFindEmployeeById");
    }

    @After("within(com.spring.professional.service.a.*)")
    public void afterExecutionWithinPackage(){
        System.out.println("Service A - afterExecutionWithinPackage");
    }
}
