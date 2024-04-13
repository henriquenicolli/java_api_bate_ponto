package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "TBL_EMPREGADO")
public class EmpregadoEntity {

    @Id
    @Column(name = "id_empregado")
    private int idEmpregado;

    @Column(name = "num_seq_registro")
    private String numSeqRegistro;

    @Column(name = "emp_nome")
    private String empNome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "banco")
    private String banco;

    @Column(name = "agencia")
    private String agencia;

    @Column(name = "conta")
    private String conta;

    @Column(name = "cod_idef_ctps")
    private String codIdefCtps;

    @Column(name = "cod_idef_caepf")
    private String codIdefCaepf;

    @Column(name = "cod_idef_cno")
    private String codIdefCno;

    @Column(name = "cod_matricula_esocial")
    private String codMatriculaEsocial;

    @ManyToOne
    @JoinColumn(name = "id_empresa_endereco")
    private EnderecoEntity endereco;

    @ManyToOne
    @JoinColumn(name = "id_horario_contratual")
    private HorarioContratualEntity horarioContratual;

    @OneToOne
    @JoinColumn(name = "id_telefone")
    private TelefoneEntity telefone;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

}