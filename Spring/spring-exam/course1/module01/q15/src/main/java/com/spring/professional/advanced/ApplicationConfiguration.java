package com.spring.professional.advanced;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "com.spring.professional.advanced.beans",
        includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Bean"),
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*(Component|Controller).*")
)
public class ApplicationConfiguration {
}
