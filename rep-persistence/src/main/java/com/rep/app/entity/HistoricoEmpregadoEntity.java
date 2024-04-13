package com.rep.app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_HISTORICO_EMPREGADO")
public class HistoricoEmpregadoEntity {

    @Id
    @Column(name = "id_historico_empregado")
    private int idHistoricoEmpregado;

    @Column(name = "num_seq_registro")
    private int numSeqRegistro;

    @Column(name = "cpf_usuario_inclusao_alteracao")
    private String cpfUsuarioInclusaoAlteracao;

    @Column(name = "tipo_operacao")
    private String tipoOperacao;

    @Column(name = "data_hora_inclusao_alteracao")
    private LocalDateTime dataHoraInclusaoAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_empregado")
    private EmpregadoEntity empregado;

}
