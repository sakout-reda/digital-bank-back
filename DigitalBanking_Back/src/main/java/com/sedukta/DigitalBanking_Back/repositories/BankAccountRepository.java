package com.sedukta.DigitalBanking_Back.repositories;

import com.sedukta.DigitalBanking_Back.entities.BankAccount;
import com.sedukta.DigitalBanking_Back.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
