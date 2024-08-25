package com.rep.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoEmpregadoDTO {

    private String idHistoricoEmpregado;
    private int numSeqRegistro;
    private String cpfUsuarioInclusaoAlteracao;
    private String tipoOperacao;
    private LocalDateTime dataHoraInclusaoAlteracao;
    private String idEmpregado;
    private String idUsuarioInclusaoAlteracao;

}
