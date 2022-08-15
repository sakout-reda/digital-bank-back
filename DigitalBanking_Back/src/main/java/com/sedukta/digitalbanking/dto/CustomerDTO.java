package com.sedukta.digitalbanking.dto;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO {
    private Long id;
    private String fullName;
    private Date birthday;
    private String phoneNumber;
    private String adress;
    private String email;
}
