package com.sedukta.digitalbanking.repositories;

import com.sedukta.digitalbanking.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
     @Query("select c  from Customer c where c.fullName like :fullName and c.adress  like :adress and c.email  like :email and c.phoneNumber like :phoneNumber and cast(c.birthday as string) like :birthday ")
    Page<Customer> searchCustomer(String fullName, String adress, String email, String phoneNumber,String birthday , Pageable pageable);

    Page<Customer> findAll(Pageable pageable);
}
