package com.sedukta.digitalbanking.services;

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
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double intrestRate, Long customerId) throws CustomerNotFoundException;
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BalanceNotSufficientException, AccountNotActivatedException;
    void credit(String accountId, double amount, String description) throws  BankAccountNotFoundException, AccountNotActivatedException;
    void transfer(String accountIdSource, String accountIdDestination,double amount) throws BankAccountNotFoundException, AccountNotActivatedException,BankAccountNotFoundException, AccountNotActivatedException;
}
