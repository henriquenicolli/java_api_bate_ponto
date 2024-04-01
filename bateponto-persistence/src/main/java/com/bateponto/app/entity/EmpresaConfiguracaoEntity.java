package com.bateponto.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "TBL_EMPR_CONFIG")
public class EmpresaConfiguracaoEntity {

    @Id
    @Column(name = "id_empresa_config")
    private Integer idTipoRegistroPonto;

    @Column(name = "carga_horaria_mensal")
    private Integer cargaHorariaMensal;

    @Column(name = "TBL_EMPRESA_id_empresa")
    private Integer id_empresa;

}
