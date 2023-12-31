package org.softuni.carpartsshop.config;

import org.softuni.carpartsshop.controllers.FirstInterceptor;
import org.softuni.carpartsshop.controllers.TimeoutInterceptor;
import org.softuni.carpartsshop.controllers.UserParametersInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor());
        registry.addInterceptor(new UserParametersInterceptor());
        registry.addInterceptor(new TimeoutInterceptor());
    }

}
