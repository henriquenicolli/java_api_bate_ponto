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
@Entity(name = "TBL_FUNCIONARIO")
public class FuncionarioEntity {

    @Id
    @Column(name = "id_funcionario")
    private Integer idFuncionario;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private EmpresaEntity empresa;

    @Column(name = "func_nome")
    private String nome;

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

    @Column(name = "data_admissao")
    private Date dataAdmissao;

    @Column(name = "ctps")
    private String ctps;

    @Column(name = "telefone_1")
    private String telefone1;

    @Column(name = "telefone_2")
    private String telefone2;

    @Column(name = "cpf")
    private String cpf;

}