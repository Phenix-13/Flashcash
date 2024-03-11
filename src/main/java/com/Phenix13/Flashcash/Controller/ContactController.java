package com.Phenix13.Flashcash.Controller;

import com.Phenix13.Flashcash.Service.ContactFormService;
import com.Phenix13.Flashcash.Service.form.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    private final ContactFormService contactFormService;

    public ContactController(ContactFormService contactFormService) {
        this.contactFormService = contactFormService;
    }

    @GetMapping("/contactForm")
    public ModelAndView contactForm(Model model){
        model.addAttribute("contactForm",new ContactForm());
        return new ModelAndView("/contactForm");
    }

    @PostMapping("/contactForm")
    public String newContactForm(@ModelAttribute("contactForm") ContactForm contactForm){
        contactFormService.newContactForm(contactForm);
        return "redirect:/user/userProfile";
    }
}
