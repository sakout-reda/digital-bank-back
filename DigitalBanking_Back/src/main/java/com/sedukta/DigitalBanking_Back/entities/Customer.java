package com.sedukta.DigitalBanking_Back.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long id;
    private String fullName;
    private String login;
    private String password;
    private Date birthday;
    private String phoneNumber;
    private String adress;
    private Referential sexe;
    private String email;
    private List<BankAccount> bankAccounts;
}
