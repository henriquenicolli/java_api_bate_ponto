package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TBL_REGISTRO_FERIAS")
public class RegistroFeriasEntity {

    @Id
    @Column(name = "id_registro_ferias")
    private String idRegistroFerias;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "qtde_dias")
    private int qtdeDias;

    @ManyToOne
    @JoinColumn(name = "id_empregado")
    private EmpregadoEntity empregado;

}
