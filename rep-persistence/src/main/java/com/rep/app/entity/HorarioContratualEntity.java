package com.rep.app.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "TBL_HORARIO_CONTRATUAL")
public class HorarioContratualEntity {

    @Id
    @Column(name = "cod_hora_contratual")
    private int codHoraContratual;

    @Column(name = "duracao_jornada")
    private int duracaoJornada;

    @Column(name = "hora_primeira_entrada")
    private LocalTime horaPrimeiraEntrada;

    @Column(name = "hora_primeira_saida")
    private LocalTime horaPrimeiraSaida;

    @Column(name = "hora_segunda_entrada")
    private LocalTime horaSegundaEntrada;

    @Column(name = "hora_segunda_saida")
    private LocalTime horaSegundaSaida;

}
