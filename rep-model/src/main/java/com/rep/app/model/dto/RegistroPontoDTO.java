package com.rep.app.model.dto;

import com.rep.app.model.enums.TipoRegistro;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegistroPontoDTO {

    @JsonProperty(value = "dataHoraRegistroPonto")
    private LocalDateTime dataHoraRegistroPonto;

    @JsonProperty(value = "latitude")
    private String latitude;

    @JsonProperty(value = "longitude")
    private String longitude;

    @JsonProperty(value = "tipoRegistro")
    private TipoRegistro tipoRegistro;

}
