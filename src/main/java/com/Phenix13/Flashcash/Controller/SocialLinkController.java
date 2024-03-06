package com.Phenix13.Flashcash.Controller;

import com.Phenix13.Flashcash.Model.User;
import com.Phenix13.Flashcash.Repository.SocialLinkRepository;
import com.Phenix13.Flashcash.Repository.UserRepository;
import com.Phenix13.Flashcash.Service.CustomService;
import com.Phenix13.Flashcash.Service.SocialLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SocialLinkController {
    private final SocialLinkService socialLinkService;
    private final UserRepository userRepository;
    private final SocialLinkRepository socialLinkRepository;
    private final CustomService customService;

    public SocialLinkController(SocialLinkService socialLinkService, UserRepository userRepository, SocialLinkRepository socialLinkRepository, CustomService customService) {
        this.socialLinkService = socialLinkService;
        this.userRepository = userRepository;
        this.socialLinkRepository = socialLinkRepository;
        this.customService = customService;
    }

    @GetMapping("/socialLinkForm")
    public ModelAndView socialLinkForm(Model model){
        model.addAttribute("socialLinkForm",new User());
        return new ModelAndView("/socialLink/socialLinkForm");
    }

    @PostMapping("/socialLinkForm")
    public String addFriend(@ModelAttribute("socialLinkForm") User newfriend){
        socialLinkService.addFriend(newfriend);
        return "redirect:/socialLinkForm";
    }

    @GetMapping("/socialLinkListForm")
    public ModelAndView socialLinkListForm(Model model){
        model.addAttribute("linkList", socialLinkService.getAllFriend());
        return new ModelAndView("/socialLink/socialLinkListForm");
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        User user = userRepository.findUserByemail(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        socialLinkRepository.delete(socialLinkRepository.findSocialLinkByUser1EmailAndUser2Email(customService.sessionUser().getEmail(),id));
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/socialLinkListForm";
    }
}
