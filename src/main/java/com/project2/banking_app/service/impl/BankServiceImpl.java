package com.project2.banking_app.service.impl;

import com.project2.banking_app.dto.BankAccountDto;
import com.project2.banking_app.entity.BankAccount;
import com.project2.banking_app.mapper.AccountMapper;
import com.project2.banking_app.repository.BankRepository;
import com.project2.banking_app.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
