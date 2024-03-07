package com.Phenix13.Flashcash.Controller;

import com.Phenix13.Flashcash.Model.Transfer;
import com.Phenix13.Flashcash.Repository.UserRepository;
import com.Phenix13.Flashcash.Service.CustomService;
import com.Phenix13.Flashcash.Service.TransferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransferController {
    private final CustomService customService;
    private final UserRepository userRepository;
    private final TransferService transferService;

    public TransferController(CustomService customService, UserRepository userRepository, TransferService transferService) {
        this.customService = customService;
        this.userRepository = userRepository;
        this.transferService = transferService;
    }

    @GetMapping("/transfer/{id}")
    public ModelAndView transfer(@PathVariable("id") String mail, Model model) {
        Transfer transfer = new Transfer();
        transfer.setUser_from(customService.sessionUser());
        transfer.setUser_to(userRepository.findUserByemail(mail).get());
        model.addAttribute("transfer", transfer);
        return new ModelAndView("/transfer/transferForm");
    }
    @PostMapping("/transferForm")
    public String transfer(@ModelAttribute("transfer") Transfer transfer){
        transferService.newTransfer(transfer);
        return "redirect:/user/userProfile";
    }
}
