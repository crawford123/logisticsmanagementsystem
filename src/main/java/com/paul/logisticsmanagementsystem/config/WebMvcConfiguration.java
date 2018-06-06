package com.paul.logisticsmanagementsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * created with IntelliJ IDEA
 * User: FengZhi
 * Date: 3/13/2018
 * Time: 3:40 PM
 * Email:2045532295@qq.com
 * Addres:zhbit
 * Description:
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/static/");
        super.addResourceHandlers(registry);
    }

}
