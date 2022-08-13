package com.sedukta.DigitalBanking_Back.repositories;

import com.sedukta.DigitalBanking_Back.entities.AccountOperation;
import com.sedukta.DigitalBanking_Back.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
