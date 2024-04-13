package com.rep.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_FONTE_MARCACAO")
public class FonteMarcacaoEntity {

    @Id
    @Column(name = "cod_fonte_marcacao")
    private int codFonteMarcacao;

    @Column(name = "descricao")
    private String descricao;

}
