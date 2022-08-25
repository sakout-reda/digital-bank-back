package com.sedukta.digitalbanking.repositories;

import com.sedukta.digitalbanking.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select c from Customer c where c.fullName like :kw")
    List<Customer> searchCustomer(@Param("kw") String keyword);

    Page<Customer> findAll(Pageable pageable);
}
