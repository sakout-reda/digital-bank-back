package com.sedukta.digitalbanking.repositories;

import com.sedukta.digitalbanking.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //    @Query("select c  from customer c where c.full_name like '%%' and c.adress  like '%%' and c.email  like '%%' and c.phone_number like '%%' and c.birthday::text like '%%'")
//    @Query("select c from Customer c where c.fullName like :kw")
    @Query("select c  from Customer c where c.fullName like :fullName and c.adress  like :adress and c.email  like :email and c.phoneNumber like :phoneNumber")
    Page<Customer> searchCustomer(String fullName, String adress, String email, String phoneNumber, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);
}
