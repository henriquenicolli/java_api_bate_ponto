package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_TELEFONE")
public class TelefoneEntity {

    @Id
    @Column(name = "id_telefone_emp")
    private String idTelefoneEmp;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cod_operadora")
    private String codOperadora;

    @Column(name = "whatsapp")
    private boolean whatsapp;

    @PrePersist
    public void generateId() {
        idTelefoneEmp = UUID.randomUUID().toString();
    }
}
