package com.sedukta.DigitalBanking_Back.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CA")
@Entity
public class CurrentAccount extends BankAccount{
    private double overDraft;
}
