package com.Phenix13.Flashcash.config;

import com.Phenix13.Flashcash.Service.form.SignUpForm;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }

    @GetMapping("/login")
    public ModelAndView showRegisterForm(){return new ModelAndView("login","signUpForm",new SignUpForm());}
}
