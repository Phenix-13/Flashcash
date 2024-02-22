package com.Phenix13.Flashcash.Service;

import com.Phenix13.Flashcash.Model.Account;
import com.Phenix13.Flashcash.Repository.AccountRepository;
import com.Phenix13.Flashcash.Repository.UserRepository;
import com.Phenix13.Flashcash.Service.form.AddIbanForm;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CustomService customService;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository, CustomService customService) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.customService = customService;
    }

    public void modifyIban(AddIbanForm iban){
        Account curAccount = customService.sessionUser().getAccount();
        curAccount.setIban1(iban.getIban());
        accountRepository.save(curAccount);

    }
}
