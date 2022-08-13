package com.sedukta.DigitalBanking_Back.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Referential {
    private int id;
    private String code;
    private String libelle;
    private Referential parent;
}
