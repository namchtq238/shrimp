package com.pondmanage.service;

import com.pondmanage.dto.AccountDTO;
import com.pondmanage.dto.PasswordDTO;

public interface AccountService {
    void register(AccountDTO accountDTO);
    void changePassword(PasswordDTO passwordDTO);
}
