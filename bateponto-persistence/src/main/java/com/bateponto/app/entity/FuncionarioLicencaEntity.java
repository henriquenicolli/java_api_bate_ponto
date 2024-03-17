package com.bateponto.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "TBL_FUNC_LICENSA")
public class FuncionarioLicencaEntity {

    @Id
    @Column(name = "id_func_licensa")
    private Integer idFuncLicensa;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    private FuncionarioEntity funcionarioEntity;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @ManyToOne
    @JoinColumn(name = "id_tipo_licenca", referencedColumnName = "id_tipo_licenca")
    private TipoLicencaEntity tipoLicencaEntity;

}
