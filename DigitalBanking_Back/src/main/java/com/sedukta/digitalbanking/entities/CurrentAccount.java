package com.sedukta.digitalbanking.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@DiscriminatorValue("CA")
@Entity
public class CurrentAccount extends BankAccount{
    private double overDraft;
}
