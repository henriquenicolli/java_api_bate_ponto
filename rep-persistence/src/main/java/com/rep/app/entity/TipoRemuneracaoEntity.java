package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TBL_TIPO_REMUNERACAO")
public class TipoRemuneracaoEntity {

    @Id
    @Column(name = "id_tipo_remuneracao")
    private int idTipoRemuneracao;

    @Column(name = "descricao")
    private String descricao;

}