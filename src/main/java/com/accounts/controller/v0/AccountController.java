package com.accounts.controller.v0;

import com.accounts.model.Account;
import com.accounts.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountService service;

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAll(){
        List<Account> account = service.getAllAccounts();
        return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        Account savedAccount = service.saveAccount(account);
        return new ResponseEntity<>(savedAccount , HttpStatus.CREATED);
    }

    @GetMapping("/ById")
    public ResponseEntity<Optional<Account>> getById(@RequestParam Long id){
        Optional<Account> account = service.getAccountById(id);
        if (account.isPresent()){
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserById(@RequestParam Long id){
        boolean deleted = service.deleteAccountById(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        } else {
           return  ResponseEntity.notFound().build();
        }
    }

    @GetMapping("api/accounts")
    public ResponseEntity<Page<Account>>  getAccounts(Pageable pageable){
        return new ResponseEntity<>(service.findAllAccount(pageable), HttpStatus.OK);
    }
}
