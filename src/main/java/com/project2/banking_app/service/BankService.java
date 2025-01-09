package com.project2.banking_app.service;

import com.project2.banking_app.dto.BankAccountDto;

import java.util.List;

public interface BankService {
    public BankAccountDto createBankAccount(BankAccountDto bankAccountDto);
    public BankAccountDto getAccountById(Long accountId);
    public List<BankAccountDto> getAllAccounts();
    public BankAccountDto deposit(Long accountId, double amount);
    public BankAccountDto withdraw(Long accountId, double amount);
    public void deleteAccount(Long accountId);
}
