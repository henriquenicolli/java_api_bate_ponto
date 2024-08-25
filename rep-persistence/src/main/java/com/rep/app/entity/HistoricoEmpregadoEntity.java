package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_HISTORICO_EMPREGADO")
public class HistoricoEmpregadoEntity {

    @Id
    @Column(name = "id_historico_empregado")
    private String idHistoricoEmpregado;

    @Column(name = "num_seq_registro")
    private int numSeqRegistro;

    @Column(name = "cpf_usuario_inclusao_alteracao")
    private String cpfUsuarioInclusaoAlteracao;

    @Column(name = "tipo_operacao_inclusao_alteracao")
    private String tipoOperacao;

    @Column(name = "data_hora_inclusao_alteracao")
    private LocalDateTime dataHoraInclusaoAlteracao;

    @ManyToOne
    @JoinColumn(name = "id_empregado")
    private EmpregadoEntity empregado;

    @OneToOne
    @JoinColumn(name = "id_usuario_inclusao_alteracao")
    private UsuarioEntity usuarioInclusaoAlteracao;

    @PrePersist
    public void generateId() {
        idHistoricoEmpregado = UUID.randomUUID().toString();
    }

}
