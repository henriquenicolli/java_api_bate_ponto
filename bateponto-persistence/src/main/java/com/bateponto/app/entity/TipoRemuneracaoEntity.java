package com.bateponto.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "TBL_TIPO_REMUNERACAO")
public class TipoRemuneracaoEntity {

    @Id
    @Column(name = "id_tipo_remuneracao")
    private Integer idTipoRemuneracao;

    @Column(name = "descricao")
    private String descricao;

}