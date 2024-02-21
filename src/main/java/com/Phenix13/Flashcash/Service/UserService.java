package com.Phenix13.Flashcash.Service;

import com.Phenix13.Flashcash.Model.Account;
import com.Phenix13.Flashcash.Model.User;
import com.Phenix13.Flashcash.Repository.UserRepository;
import com.Phenix13.Flashcash.Service.form.SignUpForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registration(SignUpForm form){
        User user = new User();
        Account account = new Account();
        account.setAmount(0.0);
        user.setAccount(account);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        userRepository.save(user);
        return user;
    }


}
