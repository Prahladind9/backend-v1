package com.spring.professional.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AlternativeCurrenciesRepositoryAspect {
    @Before("this(com.spring.professional.bls.AlternativeCurrenciesRepository)")
    public void beforeThisCurrenciesRepository(){
        System.out.println("Before - this(AlternativeCurrenciesRepository)");
    }

    @Before("this(com.spring.professional.bls.AlternativeCurrenciesRepository)")
    public void beforeTargetCurrenciesRepository(){
        System.out.println("Before - target(AlternativeCurrenciesRepository)");
    }
}
