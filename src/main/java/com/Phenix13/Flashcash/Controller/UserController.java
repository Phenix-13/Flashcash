package com.Phenix13.Flashcash.Controller;

import com.Phenix13.Flashcash.Model.User;
import com.Phenix13.Flashcash.Repository.UserRepository;
import com.Phenix13.Flashcash.Service.CustomService;
import com.Phenix13.Flashcash.Service.UserService;
import com.Phenix13.Flashcash.Service.form.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final CustomService customService;
    public UserController(UserService userService, UserRepository userRepository, CustomService customService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.customService = customService;
    }

    @GetMapping("/")
    public String home(Model model){
        return "redirect:/user/userProfile";
    }

    @GetMapping("/user/userProfile")
    public ModelAndView userProfile(Model model){
        model.addAttribute("users",customService.sessionUser());
        return new ModelAndView("/user/userProfile");
    }

    @PostMapping("/signUp")
    public ModelAndView processRequest(@ModelAttribute("signUpForm")SignUpForm form){
        User user = userService.registration(form);
        return new ModelAndView("signIn");
    }

    @GetMapping("/signUp")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signUp","signUpForm",new SignUpForm());
    }

}
