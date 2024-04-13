package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TBL_EMPRESA")
public class EmpresaEntity {

    @Id
    @Column(name = "id_empresa")
    private int idEmpresa;

    @Column(name = "num_seq_registro")
    private int numSeqRegistro;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "tipo_idef_empregador")
    private String tipoIdentificacaoEmpregador;

    @Column(name = "cnpj")
    private long cnpj;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cod_idef_cei")
    private String codIdefCei;

    @Column(name = "cod_idef_caepf")
    private long codIdefCaepf;

    @Column(name = "cod_idef_cno")
    private long codIdefCno;

    @Column(name = "data_hora_inclusao_alteracao")
    private LocalDateTime dataHoraInclusaoAlteracao;

    @Column(name = "tipo_operacao_inclusao_alteracao")
    private String tipoOperacaoInclusaoAlteracao;

    @Column(name = "codigo_usuario_inclusao_alteracao")
    private String codigoUsuarioInclusaoAlteracao;

    @OneToOne
    @JoinColumn(name = "id_telefone")
    private TelefoneEntity telefone;

}
