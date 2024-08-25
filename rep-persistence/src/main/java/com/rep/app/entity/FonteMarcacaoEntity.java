package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_FONTE_MARCACAO")
public class FonteMarcacaoEntity {

    @Id
    @Column(name = "cod_fonte_marcacao")
    private String codFonteMarcacao;

    @Column(name = "descricao")
    private String descricao;

}
