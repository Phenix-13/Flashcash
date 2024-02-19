package com.Phenix13.Flashcash.Controller;

import com.Phenix13.Flashcash.Service.UserService;
import com.Phenix13.Flashcash.Service.form.SignInForm;
import com.Phenix13.Flashcash.Service.form.SignUpForm;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/")
    public ModelAndView home(Model model){return new ModelAndView("/User/userProfile");}

    @PostMapping("/signUp")
    public ModelAndView processRequest(@ModelAttribute("signUpForm")SignUpForm form){
        userService.registration(form);
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signUp","signUpForm",new SignUpForm());
    }

    @GetMapping("/User/userProfile")
    public String logoff(Model model){
        return "User/userProfile";
    }
}
