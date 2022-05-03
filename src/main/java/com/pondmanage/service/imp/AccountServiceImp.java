package com.pondmanage.service.imp;


import com.pondmanage.dto.AccountDTO;
import com.pondmanage.dto.PasswordDTO;
import com.pondmanage.model.Account;
import com.pondmanage.repository.AccountRepository;
import com.pondmanage.security.CustomAccountDetails;
import com.pondmanage.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void register(AccountDTO accountDTO) {
        Account account = new Account();
        account.setAddress(accountDTO.getAddress());
        account.setEmail(accountDTO.getEmail());
        account.setName(accountDTO.getName());
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        account.setPhoneNumber(accountDTO.getPhoneNumber());
        accountRepository.save(account);
    }

    @Override
    public void changePassword(PasswordDTO passwordDTO) {
        Account account = currentAccount();
        if (passwordEncoder.matches(passwordDTO.getOldPassword(), account.getPassword())
            && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())){
            account.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
            accountRepository.save(account);
        }
    }

    public Account currentAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomAccountDetails details = (CustomAccountDetails) authentication.getPrincipal();
        return details.getAccount();
    }
}
