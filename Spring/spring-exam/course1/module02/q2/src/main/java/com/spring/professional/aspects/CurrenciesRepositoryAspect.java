package com.spring.professional.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CurrenciesRepositoryAspect {
    @Before("target(com.spring.professional.bls.CurrenciesRepositoryImpl)")
    public void beforeThisCurrenciesRepository(){
        System.out.println("Before - this(CurrenciesRepository)");
    }

    @Before("target(com.spring.professional.bls.CurrenciesRepositoryImpl)")
    public void beforeTargetCurrenciesRepository(){
        System.out.println("Before - target(CurrenciesRepository)");
    }
}
