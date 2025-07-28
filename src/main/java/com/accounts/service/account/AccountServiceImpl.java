package com.accounts.service.account;

import com.accounts.model.Account;
import com.accounts.repo.AccountRepo;
import com.accounts.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo service;

    @Autowired
    private PersonRepo personService;

    @Override
    public List<Account> getAllAccounts() {
        return service.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
          return this.service.save(account);
    }

    @Override
    public Optional<Account> getAccountById(long id) {
        return service.findById(id);
    }

    @Override
    public boolean deleteAccountById(long id) {
        Optional<Account> person = service.findById(id);
        if (person.isPresent()){
            service.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<Account> findAllAccount(Pageable pageable) {
        return service.findAll(pageable);
    }
}
