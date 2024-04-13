package com.rep.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TBL_TELEFONE")
public class TelefoneEntity {

    @Id
    @Column(name = "id_telefone_emp")
    private int idTelefoneEmp;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cod_operadora")
    private String codOperadora;

    @Column(name = "whatsapp")
    private boolean whatsapp;

}
