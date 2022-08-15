package com.sedukta.digitalbanking.dto;

import com.sedukta.digitalbanking.entities.AccountOperation;
import com.sedukta.digitalbanking.entities.Customer;
import com.sedukta.digitalbanking.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class BankAccountDTO {
    private String type;
}
