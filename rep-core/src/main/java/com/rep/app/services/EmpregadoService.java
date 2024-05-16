package com.rep.app.services;

import com.rep.app.model.dto.EmpregadoDTO;

import java.util.List;

public interface EmpregadoService {

    EmpregadoDTO salvarEmpregado(EmpregadoDTO empregadoDTO);

    List<EmpregadoDTO> buscarEmpregado(String idEmpresa);
}
