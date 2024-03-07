package com.Phenix13.Flashcash.Controller;

import com.Phenix13.Flashcash.Model.Transfert;
import com.Phenix13.Flashcash.Repository.UserRepository;
import com.Phenix13.Flashcash.Service.CustomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransfertController {
    private final CustomService customService;
    private final UserRepository userRepository;

    public TransfertController(CustomService customService, UserRepository userRepository) {
        this.customService = customService;
        this.userRepository = userRepository;
    }

    @GetMapping("/socialLinkListForm/transfert/{id}")
    public ModelAndView transfert(@PathVariable("id") String mail, Model model) {
        Transfert transfert = new Transfert();
        transfert.setUser_from(customService.sessionUser());
        transfert.setUser_to(userRepository.findUserByemail(mail).get());
        model.addAttribute("transfert", transfert);
        return new ModelAndView("/transfert/transfertForm");
    }
}
