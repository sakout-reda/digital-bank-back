package com.sedukta.digitalbanking.services;

import com.sedukta.digitalbanking.dto.AccountHistoryDTO;
import com.sedukta.digitalbanking.dto.AccountOperationDTO;
import com.sedukta.digitalbanking.dto.BankAccountDTO;
import com.sedukta.digitalbanking.dto.CustomerDTO;
import com.sedukta.digitalbanking.entities.CurrentAccount;
import com.sedukta.digitalbanking.entities.SavingAccount;
import com.sedukta.digitalbanking.exceptions.DigitalBankException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws DigitalBankException;

    SavingAccount saveSavingBankAccount(double initialBalance, double intrestRate, Long customerId) throws DigitalBankException;

    Page<CustomerDTO> listCustomers(Pageable pageable);

    Page<CustomerDTO> searchCustomers(String fullName, String adress, String email, String phoneNumber, Pageable pageable);

    BankAccountDTO getBankAccount(String accountId) throws DigitalBankException;

    void debit(String accountId, double amount, String description) throws DigitalBankException;

    void credit(String accountId, double amount, String description) throws DigitalBankException;

    void transfer(String accountIdSource, String accountIdDestination, double amount) throws DigitalBankException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws DigitalBankException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws DigitalBankException;


}
