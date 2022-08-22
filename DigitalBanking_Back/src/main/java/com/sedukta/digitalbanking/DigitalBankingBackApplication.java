package com.sedukta.digitalbanking;

import com.sedukta.digitalbanking.entities.AccountOperation;
import com.sedukta.digitalbanking.entities.CurrentAccount;
import com.sedukta.digitalbanking.entities.Customer;
import com.sedukta.digitalbanking.entities.SavingAccount;
import com.sedukta.digitalbanking.enums.AccountStatus;
import com.sedukta.digitalbanking.enums.OperationType;
import com.sedukta.digitalbanking.repositories.AccountOperationRepository;
import com.sedukta.digitalbanking.repositories.BankAccountRepository;
import com.sedukta.digitalbanking.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingBackApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner start(CustomerRepository customerRepository,
//                            BankAccountRepository bankAccountRepository,
//                            AccountOperationRepository accountOperationRepository) {
//        return args -> {
//            Stream.of("Hassan", "Yassine", "Aicha").forEach(name -> {
//                Customer customer = new Customer();
//                customer.setFullName(name);
//                customer.setEmail(name + "@gmail.com");
//                customer.setBirthday(new Date());
//                customerRepository.save(customer);
//            });
//            customerRepository.findAll().forEach(customer -> {
//                CurrentAccount currentAccount = new CurrentAccount();
//                currentAccount.setOverDraft(Math.floor(Math.random() * Math.pow(10, 3)));
//                currentAccount.setCreatedAt(new Date());
//                currentAccount.setStatus(AccountStatus.CREATED);
//                currentAccount.setCustomer(customer);
//                currentAccount.setId(UUID.randomUUID().toString());
//                bankAccountRepository.save(currentAccount);
//
//                SavingAccount savingAccount = new SavingAccount();
//                savingAccount.setIntrestRate(Math.floor(Math.random() * 10));
//                savingAccount.setCreatedAt(new Date());
//                savingAccount.setStatus(AccountStatus.CREATED);
//                savingAccount.setCustomer(customer);
//                savingAccount.setId(UUID.randomUUID().toString());
//                bankAccountRepository.save(savingAccount);
//
//                bankAccountRepository.findAll().forEach(account -> {
//                    AccountOperation accountOperation = new AccountOperation();
//                    for (int i = 0; i < 5; i++) {
//                        accountOperation.setOperationDate(new Date());
//                        accountOperation.setAmount(Math.floor(Math.random() * Math.pow(10, 3)));
//                        accountOperation.setType(Math.random() > 0.5 ? OperationType.CREDIT : OperationType.DEBIT);
//                        accountOperation.setBankAccount(account);
//                        accountOperationRepository.save(accountOperation);
//                    }
//                });
//            });
//
//
//        };
//    }

}
