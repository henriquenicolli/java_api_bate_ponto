package com.rep.app.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroPontoRequest {

    private String numeroSequencialRegistro;
    private LocalDate dataMarcacaoPonto;
    private LocalTime horaMarcacaoPonto;
    private String fusoHorarioMarcacao;
    private String fusoHorarioRegistro;
    private boolean marcacaoOnline;
    private String cpfFuncionario;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String motivoMarcacao;
    private Integer coletorRegistro;
    private String tipoMarcacao;
    private String fonteMarcacao;
    private String idEmpregado;
    private Boolean registroAlterado;
    private Boolean registroAlteradoAprovacao;
    private LocalTime horaMarcacaoPontoOriginal;

}
