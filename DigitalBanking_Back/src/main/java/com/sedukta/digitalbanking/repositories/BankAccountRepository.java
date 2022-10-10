package com.sedukta.digitalbanking.repositories;

import com.sedukta.digitalbanking.entities.BankAccount;
import com.sedukta.digitalbanking.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

    Page<BankAccount> findAll(Pageable pageable);
}
