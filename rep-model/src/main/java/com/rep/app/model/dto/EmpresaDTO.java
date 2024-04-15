package com.rep.app.model.dto;

import com.rep.app.model.enums.TipoOperacaoInslucaoAlteracao;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {

    private String idEmpresa;
    private int numSeqRegistro;
    private String nomeEmpresa;
    private String razaoSocial;
    private String tipoIdefEmpregador;
    private long cnpj;
    private String cpf;
    private String codIdefCei;
    private long codIdefCaepf;
    private long codIdefCno;
    private LocalDateTime dataHoraInclusaoAlteracao;
    private TipoOperacaoInslucaoAlteracao tipoOperacaoInclusaoAlteracao;
    private TelefoneDTO telefone;
    private UsuarioDTO usuarioInclusaoAlteracao;

}
