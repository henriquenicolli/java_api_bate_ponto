package com.bateponto.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "TBL_TIPO_REGISTRO_PONTO")
public class TipoRegistroPontoEntity {

    @Id
    @Column(name = "id_tipo_registro_ponto")
    private Integer idTipoRegistroPonto;

    @Column(name = "descricao")
    private String descricao;

}