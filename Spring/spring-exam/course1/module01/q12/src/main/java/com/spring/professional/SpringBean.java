package com.spring.professional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean {

    /*@Value("${db.host}")
    private String dbHost;
    @Value("${db.port}")
    private String dbPort;*/
    @Value("${app.env}")
    private String appEnv;
    @Value("${app.envid}")
    private String appEnvId;
    @Value("${JAVA_HOME}")
    private String javaHome;

    public void printProperties(){
        /*System.out.println("db.host = " + dbHost);
        System.out.println("db.port = " + dbPort);*/
        System.out.println("app.env = " + appEnv);
        System.out.println("app.envid = " + appEnvId);
        System.out.println("javaHome = " + javaHome);
    }


}
