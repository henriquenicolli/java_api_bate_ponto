package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TBL_TIPO_LICENCA")
public class TipoLicencaEntity {

    @Id
    @Column(name = "cod_tipo_licenca")
    private int idTipoLicenca;

    @Column(name = "descricao")
    private String descricao;

}