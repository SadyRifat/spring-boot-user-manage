package com.user.manage.config;

import com.user.manage.filter.AuthTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AuthTokenFilter> loggingFilter(){
        FilterRegistrationBean<AuthTokenFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthTokenFilter());
        registrationBean.addUrlPatterns("/serve/*");

        return registrationBean;
    }

}
