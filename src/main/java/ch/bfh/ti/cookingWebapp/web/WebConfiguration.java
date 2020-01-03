package ch.bfh.ti.cookingWebapp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

////Probably this class isn't needed
//@Configuration
//public class WebConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/admin/**").addResourceLocations("/templates/admin/");
//        registry.addResourceHandler("/**").addResourceLocations("/templates/regular/");
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("main_page");
//    }
//
//}