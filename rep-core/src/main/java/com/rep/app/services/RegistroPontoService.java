package com.rep.app.services;

import com.rep.app.model.dto.RegistroPontoDTO;

import java.util.List;

public interface RegistroPontoService {

    RegistroPontoDTO salvarRegistroPonto(RegistroPontoDTO oldRegistroPontoDTO);

    List<RegistroPontoDTO> findByMesMarcacaoPonto(int mes);

}
