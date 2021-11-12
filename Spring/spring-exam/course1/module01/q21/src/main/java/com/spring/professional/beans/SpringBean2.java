package com.spring.professional.beans;

public class SpringBean2 {
    private void destroy(){
        System.out.println(getClass().getSimpleName() + "::destroy()");
    }
}
