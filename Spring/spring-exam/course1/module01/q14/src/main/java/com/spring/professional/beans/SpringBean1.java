package com.spring.professional.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpringBean1 implements InitializingBean {

    @PostConstruct
    public void postConstruct(){
        System.out.println(getClass().getSimpleName() + " - postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getSimpleName() + " - afterPropertiesSet");
    }

    private void initMethod(){
        System.out.println(getClass().getSimpleName() + " - initMethod");
    }
}
