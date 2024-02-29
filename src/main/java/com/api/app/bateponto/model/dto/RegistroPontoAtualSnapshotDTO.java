package com.api.app.bateponto.model.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class RegistroPontoAtualSnapshotDTO {

    private List<ControlePontoDTO> registroPontoHojeList = new ArrayList<>();

    private List<ControlePontoDTO> registroPontoOntemList = new ArrayList<>();

    private LocalTime horasTrabalhadasHoje;

    private LocalTime horasTrabalhadasOntem;

    private LocalTime horasExtrasMes;

    private LocalTime horasCompensaveisMes;

}
