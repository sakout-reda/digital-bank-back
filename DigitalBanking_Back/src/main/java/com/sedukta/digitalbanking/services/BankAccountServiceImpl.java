package com.sedukta.digitalbanking.services;

import com.sedukta.digitalbanking.entities.*;
import com.sedukta.digitalbanking.enums.AccountStatus;
import com.sedukta.digitalbanking.exceptions.AccountNotActivatedException;
import com.sedukta.digitalbanking.exceptions.BalanceNotSufficientException;
import com.sedukta.digitalbanking.exceptions.BankAccountNotFoundException;
import com.sedukta.digitalbanking.exceptions.CustomerNotFoundException;
import com.sedukta.digitalbanking.repositories.AccountOperationRepository;
import com.sedukta.digitalbanking.repositories.BankAccountRepository;
import com.sedukta.digitalbanking.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {

    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;

    //Logger log= LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new Customer");
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public SavingAccount saveSavingBankAccount(double initialBalance, double intrestRate, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setId(UUID.randomUUID().toString());
        savingAccount.setCreatedAt(new Date());
        savingAccount.setBalance(initialBalance);
        savingAccount.setCustomer(customer);
        savingAccount.setIntrestRate(intrestRate);
        return bankAccountRepository.save(savingAccount);
    }

    @Override
    public CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found");
        }
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setId(UUID.randomUUID().toString());
        currentAccount.setCreatedAt(new Date());
        currentAccount.setBalance(initialBalance);
        currentAccount.setCustomer(customer);
        currentAccount.setOverDraft(overDraft);
        return bankAccountRepository.save(currentAccount);
    }

    @Override
    public List<Customer> listCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public BankAccount getBankAccount(String accountId) {

        return bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new BankAccountNotFoundException("BankAccount Not Found"));
    }

    @Override
    public void debit(String accountId, double amount, String description)
            throws BalanceNotSufficientException,
            BankAccountNotFoundException {
        BankAccount bankAccount = this.getBankAccount(accountId);
        if (bankAccount.getBalance() < amount) {
            throw new BalanceNotSufficientException("Balance not enough");
        }
        if (bankAccount.getStatus() != AccountStatus.ACTIVATED) {
            throw new AccountNotActivatedException("Account Not Active");
        }
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setAmount(amount);
        accountOperation.setDescription(description);
        accountOperation.setOperationDate(new Date());
        accountOperationRepository.save(accountOperation);
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        bankAccountRepository.save(bankAccount);

    }

    @Override
    public void credit(String accountId, double amount, String description) throws
            AccountNotActivatedException,
            BankAccountNotFoundException {
        BankAccount bankAccount = this.getBankAccount(accountId);
        if (bankAccount.getStatus() != AccountStatus.ACTIVATED) {
            throw new AccountNotActivatedException("Account Not Active");
        }
        AccountOperation accountOperation = new AccountOperation();
        accountOperation.setAmount(amount);
        accountOperation.setDescription(description);
        accountOperation.setOperationDate(new Date());
        accountOperationRepository.save(accountOperation);
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        bankAccountRepository.save(bankAccount);

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount)
            throws BankAccountNotFoundException,
            BalanceNotSufficientException,
            AccountNotActivatedException {
        debit(accountIdSource, amount, "Transfer to" + accountIdDestination);
        credit(accountIdDestination, amount, "Transfer from" + accountIdSource);

    }
}
