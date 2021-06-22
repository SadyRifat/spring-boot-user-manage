package com.user.manage.config;

import com.user.manage.filter.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Autowired
    private Beans beans;

    @Bean
    public FilterRegistrationBean<AuthTokenFilter> loggingFilter(){
        FilterRegistrationBean<AuthTokenFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(beans.authTokenFilter());
        registrationBean.addUrlPatterns("/serve/*");

        return registrationBean;
    }

}
