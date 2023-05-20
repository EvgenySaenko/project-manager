//package com.projectmanager.configurations;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@EnableWebMvc
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = new String[]{
//            "classpath:/resources/",
//            "classpath:/css/",
//            "classpath:/js/",
//            "classpath:/templates/"};
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/resources/**")
//                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
//    }
//}
