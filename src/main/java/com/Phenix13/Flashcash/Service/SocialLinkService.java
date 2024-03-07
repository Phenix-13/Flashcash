package com.Phenix13.Flashcash.Service;

import com.Phenix13.Flashcash.Model.SocialLink;
import com.Phenix13.Flashcash.Model.User;
import com.Phenix13.Flashcash.Repository.SocialLinkRepository;
import com.Phenix13.Flashcash.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialLinkService {
    private final SocialLinkRepository socialLinkRepository;
    private final UserRepository userRepository;
    private final CustomService customService;

    public SocialLinkService(SocialLinkRepository socialLinkRepository, UserRepository userRepository, CustomService customService) {
        this.socialLinkRepository = socialLinkRepository;
        this.userRepository = userRepository;
        this.customService = customService;
    }

    public void addFriend(User newfriend){
        SocialLink newlink = new SocialLink();
        User me = customService.sessionUser();

        User friend = userRepository.findUserByemail(newfriend.getEmail()).get();

        newlink.setUser1(me);
        newlink.setUser2(friend);
        socialLinkRepository.save(newlink);
    }

    public List<String> getAllFriend(){
        User curUser = customService.sessionUser();
        return socialLinkRepository.findSocialLinksByUser1Email(curUser.getEmail()).stream().map(SocialLink::getUser2).map(User::getEmail).collect(Collectors.toList());
    }
}
