package com.project2.banking_app.mapper;

import com.project2.banking_app.dto.BankAccountDto;
import com.project2.banking_app.entity.BankAccount;

public class AccountMapper {

    public static BankAccount mapToBankAccount(BankAccountDto bankAccountDto){
        return new BankAccount(bankAccountDto.getId(),
                bankAccountDto.getAccountHolderName(),
                bankAccountDto.getBalance());
    }

    public static BankAccountDto mapToBankAccountDto(BankAccount bankAccount){
        return new BankAccountDto(bankAccount.getId(),
                bankAccount.getAccountHolderName(),
                bankAccount.getBalance());
    }
}
