package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TBL_EMPREGADO_LICENCA")
public class EmpregadoLicencaEntity {

    @Id
    @Column(name = "id_emprg_licenca")
    private String idEmpregadoLicenca;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "id_empregado")
    private EmpregadoEntity empregado;

    @ManyToOne
    @JoinColumn(name = "cod_tipo_licenca")
    private TipoLicencaEntity tipoLicenca;

}
