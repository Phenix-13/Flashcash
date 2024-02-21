package com.Phenix13.Flashcash.Service;

import com.Phenix13.Flashcash.Model.User;
import com.Phenix13.Flashcash.Repository.UserRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomService {
    private final UserRepository userRepository;

    public CustomService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User sessionUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User user = userRepository.findUserByemail(currentUserName).get();
        return user;
    }
}
