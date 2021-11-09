package com.spring.professional.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class SpringBean2 implements DisposableBean {

    @PreDestroy
    public void preDestroy(){
        System.out.println(getClass().getSimpleName() + " - preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(getClass().getSimpleName() + " - destroy");
    }


    private void destroyMethod() {
        System.out.println(getClass().getSimpleName() + " - destroyMethod");
    }
}
