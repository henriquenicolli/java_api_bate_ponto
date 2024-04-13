package com.rep.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_TIPO_MARCACAO")
public class TipoMarcacaoEntity {

    @Id
    @Column(name = "cod_tipo_marcacao")
    private int codTipoMarcacao;

    @Column(name = "descricao")
    private String descricao;

}
