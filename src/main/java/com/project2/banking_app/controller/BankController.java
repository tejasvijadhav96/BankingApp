package com.project2.banking_app.controller;

import com.project2.banking_app.dto.BankAccountDto;
import com.project2.banking_app.entity.BankAccount;
import com.project2.banking_app.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    //build get account by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<BankAccountDto> getAccountById(@PathVariable("id") Long accountId){
        BankAccountDto bankAccountDto=bankService.getAccountById(accountId);
        return ResponseEntity.ok(bankAccountDto);
    }

    @GetMapping
    public ResponseEntity<List<BankAccountDto>> getAllAccounts(){
        List<BankAccountDto> bankAccountDtos=bankService.getAllAccounts();
        return ResponseEntity.ok(bankAccountDtos);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<BankAccountDto> deposit(@PathVariable("id") Long accountId,
                                                  @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        BankAccountDto bankAccountDto=bankService.deposit(accountId,amount);
        return ResponseEntity.ok(bankAccountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<BankAccountDto> withdraw(@PathVariable("id") Long accountId,
                                                  @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        BankAccountDto bankAccountDto=bankService.deposit(accountId,amount);
        return ResponseEntity.ok(bankAccountDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long accountId){
        bankService.deleteAccount(accountId);
        return  ResponseEntity.ok("Account deleted successfully");
    }
}
