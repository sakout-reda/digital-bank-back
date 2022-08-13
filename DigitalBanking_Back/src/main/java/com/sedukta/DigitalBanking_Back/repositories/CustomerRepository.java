package com.sedukta.DigitalBanking_Back.repositories;

import com.sedukta.DigitalBanking_Back.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
