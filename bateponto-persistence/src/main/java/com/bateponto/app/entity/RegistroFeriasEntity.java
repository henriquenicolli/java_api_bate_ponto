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
@Entity(name = "TBL_REGISTRO_FERIAS")
public class RegistroFeriasEntity {

    @Id
    @Column(name = "id_registro_ferias")
    private Integer idRegistroFerias;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    private FuncionarioEntity funcionarioEntity;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "qtde_dias")
    private Integer qtdeDias;

}
