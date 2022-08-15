package com.sedukta.digitalbanking.services;

import com.sedukta.digitalbanking.dto.AccountHistoryDTO;
import com.sedukta.digitalbanking.dto.AccountOperationDTO;
import com.sedukta.digitalbanking.dto.BankAccountDTO;
import com.sedukta.digitalbanking.dto.CustomerDTO;
import com.sedukta.digitalbanking.entities.BankAccount;
import com.sedukta.digitalbanking.entities.CurrentAccount;
import com.sedukta.digitalbanking.entities.Customer;
import com.sedukta.digitalbanking.entities.SavingAccount;
import com.sedukta.digitalbanking.exceptions.AccountNotActivatedException;
import com.sedukta.digitalbanking.exceptions.BalanceNotSufficientException;
import com.sedukta.digitalbanking.exceptions.BankAccountNotFoundException;
import com.sedukta.digitalbanking.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double intrestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BalanceNotSufficientException, AccountNotActivatedException;
    void credit(String accountId, double amount, String description) throws  BankAccountNotFoundException, AccountNotActivatedException;
    void transfer(String accountIdSource, String accountIdDestination,double amount) throws BankAccountNotFoundException, AccountNotActivatedException,BankAccountNotFoundException, AccountNotActivatedException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
