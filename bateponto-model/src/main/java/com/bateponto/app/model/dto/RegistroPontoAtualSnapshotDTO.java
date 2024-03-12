package com.bateponto.app.model.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class RegistroPontoAtualSnapshotDTO {

    private List<RegistroPontoDTO> registroPontoHojeList = new ArrayList<>();

    private List<RegistroPontoDTO> registroPontoOntemList = new ArrayList<>();

    private LocalTime horasTrabalhadasHoje;

    private LocalTime horasTrabalhadasOntem;

    private LocalTime horasExtrasMes;

    private LocalTime horasCompensaveisMes;

}
