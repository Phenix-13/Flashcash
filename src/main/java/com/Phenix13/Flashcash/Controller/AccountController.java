package com.Phenix13.Flashcash.Controller;

import com.Phenix13.Flashcash.Service.AccountService;
import com.Phenix13.Flashcash.Service.CustomService;
import com.Phenix13.Flashcash.Service.form.AddCashForm;
import com.Phenix13.Flashcash.Service.form.AddIbanForm;
import com.Phenix13.Flashcash.Service.form.SignUpForm;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    private final CustomService customService;
    private final AccountService accountService;
    public AccountController(CustomService customService, AccountService accountService) {
        this.customService = customService;
        this.accountService = accountService;
    }

    @GetMapping("/addIban")
    public ModelAndView addIbanForm(Model model){
        model.addAttribute("addIbanForm",customService.sessionUser().getAccount());
        return new ModelAndView("/user/userIban");
    }


    @PostMapping("/addIban")
    public String addIban(@ModelAttribute("addIbanForm") AddIbanForm iban){
        accountService.modifyIban(iban);
        return "redirect:/user/userProfile";
    }

    @GetMapping("/addCashForm")
    public ModelAndView addCashForm(Model model){
        return new ModelAndView("/account/addCashForm","addCashForm",new AddCashForm());
    }

    @PostMapping("/addCash")
    public String addCash(@ModelAttribute("addCashForm") AddCashForm addCashForm){
        accountService.addCash(addCashForm);
        return "redirect:/user/userProfile";
    }
}
