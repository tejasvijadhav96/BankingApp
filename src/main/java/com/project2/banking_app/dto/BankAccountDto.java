package com.project2.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccountDto {
    private Long id;
    private String accountHolderName;

    private double balance;
}
