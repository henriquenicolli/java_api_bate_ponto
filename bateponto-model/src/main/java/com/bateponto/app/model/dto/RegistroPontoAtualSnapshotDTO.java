package com.bateponto.app.model.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class RegistroPontoAtualSnapshotDTO {

    private List<RegistroPontoDTO> registroPontoHojeList = new ArrayList<>();

    private List<RegistroPontoDTO> registroPontoOntemList = new ArrayList<>();

    private LocalTime horasTrabalhadasHoje = LocalTime.MIN;

    private LocalTime horasTrabalhadasOntem = LocalTime.MIN;

    private LocalTime horasExtrasMes = LocalTime.MIN;

    private LocalTime horasExtrasHoje = LocalTime.MIN;

}
