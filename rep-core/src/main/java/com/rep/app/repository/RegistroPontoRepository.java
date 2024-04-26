package com.rep.app.repository;

import com.rep.app.model.dto.RegistroPontoDTO;

import java.time.LocalDate;
import java.util.List;

public interface RegistroPontoRepository {

    RegistroPontoDTO salvarRegistroPonto(RegistroPontoDTO registroPontoDTO);

    List<RegistroPontoDTO> findByDataInicioAndDataFim(LocalDate dataInicio, LocalDate dataFim);

    List<RegistroPontoDTO> findByMesMarcacaoPonto(int mesMarcacaoPonto);
}
