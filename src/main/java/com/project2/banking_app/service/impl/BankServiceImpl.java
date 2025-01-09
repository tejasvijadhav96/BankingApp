package com.project2.banking_app.service.impl;

import com.project2.banking_app.dto.BankAccountDto;
import com.project2.banking_app.entity.BankAccount;
import com.project2.banking_app.exception.ResourceNotFoundException;
import com.project2.banking_app.mapper.AccountMapper;
import com.project2.banking_app.repository.BankRepository;
import com.project2.banking_app.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BankServiceImpl implements BankService {

    public BankRepository bankRepository;

    @Override
    public BankAccountDto createBankAccount(BankAccountDto bankAccountDto) {
        BankAccount bankAccount= AccountMapper.mapToBankAccount(bankAccountDto);
        BankAccount savedAccount=bankRepository.save(bankAccount);
        return AccountMapper.mapToBankAccountDto(savedAccount);
    }

    @Override
    public BankAccountDto getAccountById(Long accountId) {
        BankAccount bankAccount=bankRepository.findById(accountId).orElseThrow(()->
                new ResourceNotFoundException("Account does not exists with given id:"
                        +accountId));

        return AccountMapper.mapToBankAccountDto(bankAccount);
    }

    @Override
    public List<BankAccountDto> getAllAccounts() {
        List<BankAccount> bankAccounts=bankRepository.findAll();

        return bankAccounts.stream().map(
                (account)->AccountMapper.mapToBankAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountDto deposit(Long accountId, double amount) {
        BankAccount bankAccount=bankRepository.findById(accountId).orElseThrow(()->
                new ResourceNotFoundException("Account doest not exists"));
        double total=bankAccount.getBalance()+amount;
        bankAccount.setBalance(total);
        BankAccount savedAccount=bankRepository.save(bankAccount);
        return AccountMapper.mapToBankAccountDto(savedAccount);
    }

    @Override
    public BankAccountDto withdraw(Long accountId, double amount) {
        BankAccount bankAccount=bankRepository.findById(accountId).orElseThrow(()->
                new ResourceNotFoundException("Account doest not exists"));
        if(bankAccount.getBalance()<amount){
            throw new RuntimeException("Insufficient balance");
        }
        double total=bankAccount.getBalance()-amount;
        bankAccount.setBalance(total);
        BankAccount savedAccount=bankRepository.save(bankAccount);
        return AccountMapper.mapToBankAccountDto(savedAccount);
    }

    @Override
    public void deleteAccount(Long accountId) {
        BankAccount bankAccount=bankRepository.findById(accountId).orElseThrow(()->
                new ResourceNotFoundException("Account doest not exists"));
        bankRepository.delete(bankAccount);
    }
}
