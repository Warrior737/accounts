package com.accounts.service.account;

import com.accounts.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> getAllAccounts();
    Account saveAccount(Account account);
    Optional<Account> getAccountById(long id);
    boolean deleteAccountById(long id);
    Page<Account> findAllAccount(Pageable pageable);
}
