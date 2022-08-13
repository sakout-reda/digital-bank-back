package com.sedukta.DigitalBanking_Back.entities;

import com.sedukta.DigitalBanking_Back.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountOperation {
    private Long id;
    private Date operationDate;
    private OperationType type;
    private BankAccount bankAccount;
}
