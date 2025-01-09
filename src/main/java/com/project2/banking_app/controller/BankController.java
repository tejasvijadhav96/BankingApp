package com.project2.banking_app.controller;

import com.project2.banking_app.dto.BankAccountDto;
import com.project2.banking_app.entity.BankAccount;
import com.project2.banking_app.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/accounts")
public class BankController {

    public BankService bankService;

    //build create account rest api
    @PostMapping
    public ResponseEntity<BankAccountDto> createBankAccount(@RequestBody BankAccountDto bankAccountDto){
        return new ResponseEntity<>(bankService.createBankAccount(bankAccountDto), HttpStatus.CREATED);
    }
}
