package com.rep.app.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private String idTelefone;
    private String telefone;
    private String codOperadora;
    private boolean whatsapp;

}
