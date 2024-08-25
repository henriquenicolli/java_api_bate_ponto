package com.rep.app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TBL_BANCO_HORAS")
public class BancoHorasEntity {

    @Id
    @Column(name = "id_banco_horas")
    private String idBancoHoras;

    @Column(name = "tipo_ausencia_compensacao")
    private String tipoAusenciaCompensacao;

    @Column(name = "data_ausencia_compensacao")
    private LocalDate dataAusenciaCompensacao;

    @Column(name = "quantidade_minutos")
    private int quantidadeMinutos;

    @Column(name = "tipo_movimento_banco_horas")
    private Integer tipoMovimentoBancoHoras;

    @ManyToOne
    @JoinColumn(name = "id_empregado")
    private EmpregadoEntity empregado;

}
