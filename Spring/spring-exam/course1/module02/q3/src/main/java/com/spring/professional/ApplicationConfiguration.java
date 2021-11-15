package com.spring.professional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
//@EnableAspectJAutoProxy
@EnableAspectJAutoProxy(proxyTargetClass = true) //will force spring to use CGLIB on all classes, overriding JDKProxy
public class ApplicationConfiguration {
}
