package com.Phenix13.Flashcash.Service;

import com.Phenix13.Flashcash.Model.Transfer;
import com.Phenix13.Flashcash.Model.User;
import com.Phenix13.Flashcash.Repository.TransferRepository;
import com.Phenix13.Flashcash.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransferService {
    private final UserRepository userRepository;
    private final TransferRepository transferRepository;

    public TransferService(UserRepository userRepository, TransferRepository transferRepository) {
        this.userRepository = userRepository;
        this.transferRepository = transferRepository;
    }

    public void newTransfer(Transfer transfer){
        User user1 = userRepository.findUserByemail(transfer.getUser_from().getEmail()).get();
        User user2 = userRepository.findUserByemail(transfer.getUser_to().getEmail()).get();
        double amount_before_fee = transfer.getAmount_before_fee();
        double amount_after_fee = amount_before_fee*1.005;
        user1.getAccount().setAmount(user1.getAccount().getAmount()-amount_after_fee);
        user2.getAccount().setAmount(user2.getAccount().getAmount()+amount_before_fee);
        userRepository.save(user1);
        userRepository.save(user2);
        Date date = new Date();
        transfer.setUser_from(user1);
        transfer.setUser_to(user2);
        transfer.setAmount_before_fee(amount_before_fee);
        transfer.setAmount_after_fee(amount_after_fee);
        transfer.setDateTime(date);
        transferRepository.save(transfer);
    }
}
