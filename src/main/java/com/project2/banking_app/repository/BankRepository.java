package com.project2.banking_app.repository;

import com.project2.banking_app.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankAccount,Long> {
}
