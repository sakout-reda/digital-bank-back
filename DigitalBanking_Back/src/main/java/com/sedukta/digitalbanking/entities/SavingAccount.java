package com.sedukta.digitalbanking.entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("SA")
public class SavingAccount extends BankAccount{
    private double intrestRate;
}
