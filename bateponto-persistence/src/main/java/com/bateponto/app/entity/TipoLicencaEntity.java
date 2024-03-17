package com.bateponto.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "TBL_TIPO_LICENCA")
public class TipoLicencaEntity {

    @Id
    @Column(name = "id_tipo_licenca")
    private Integer idTipoLicenca;

    @Column(name = "descricao")
    private String descricao;

}