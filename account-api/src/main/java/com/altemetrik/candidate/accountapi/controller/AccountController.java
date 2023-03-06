package com.altemetrik.candidate.accountapi.controller;
import com.altemetrik.candidate.accountapi.entity.APIResponseDto;
import com.altemetrik.candidate.accountapi.entity.AccountDTO;
import com.altemetrik.candidate.accountapi.entity.AccountEntity;
import com.altemetrik.candidate.accountapi.exception.AccountException;
import com.altemetrik.candidate.accountapi.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/account")
@RefreshScope
public class AccountController {

    private AccountService accountService;


    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccounts()
    {
        try {
            List<AccountDTO> accountDTOS = accountService.getAllAccounts();
            if(accountDTOS.isEmpty())
                System.out.println("Empty");
            return new ResponseEntity<>(accountDTOS,HttpStatus.OK);
        } catch (AccountException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserAccount(@PathVariable String email){
        try {
            APIResponseDto userAccount = accountService.getAccountAndUser(email);
            return new ResponseEntity<>(userAccount, HttpStatus.OK);
        } catch (AccountException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/create-account/{email}")
    public ResponseEntity<?> createAccount(@RequestBody AccountDTO accountDTO, @PathVariable("email") String email)
    {
        try {
            AccountDTO createdAccount = accountService.createAccount(accountDTO, email);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (AccountException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
