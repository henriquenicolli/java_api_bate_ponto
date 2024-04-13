package com.rep.app.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "TBL_COLETOR_REGISTRO")
public class ColetorRegistroEntity {

    @Id
    @Column(name = "cod_idef_coletor_registro")
    private int codIdefColetorRegistro;

    @Column(name = "descricao")
    private String descricao;

}
