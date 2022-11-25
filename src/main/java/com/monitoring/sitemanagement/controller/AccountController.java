package com.monitoring.sitemanagement.controller;

import com.monitoring.sitemanagement.model.Account;
import com.monitoring.sitemanagement.model.Project;
import com.monitoring.sitemanagement.model.Server;
import com.monitoring.sitemanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAccount() {

        List<Account> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @PostMapping("/save-account")
    public ResponseEntity<?> addAccount(@RequestBody Account account) {

         accountService.addAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-account")
    public ResponseEntity<?> updateAccount(@RequestBody Account account) {

        accountService.updateAccount(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-account/{screen_name}")
    public ResponseEntity<?> deleteByScreen_name(@PathVariable("screen_name") String screen_name) {

        accountService.deleteByScreen_name(screen_name);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {

        Account account = accountService.findByEmail(email);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
