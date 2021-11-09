package com.spring.professional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import static java.util.Arrays.stream;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        stream(beanFactory.getBeanDefinitionNames())
                .map(beanFactory::getBeanDefinition)
                .map(BeanDefinition::getBeanClassName)
                .forEach(System.out::println);
    }
}
