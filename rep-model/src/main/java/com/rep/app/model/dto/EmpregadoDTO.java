package com.rep.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpregadoDTO {

    private String idEmpregado;
    private int numSeqRegistro;
    private String empNome;
    private String cpf;
    private LocalDate dataAdmissao;
    private String email;
    private String departamento;
    private String cargo;
    private String banco;
    private String agencia;
    private String conta;
    private String codIdefCtps;
    private String codIdefCaepf;
    private String codIdefCno;
    private String codMatriculaEsocial;
    private String idEmpresaEndereco;
    private int codHorarioContratual;
    private TelefoneDTO telefone;
    private String idEmpresa;
    private String idUsuarioInclusaoAlteracao;

}
