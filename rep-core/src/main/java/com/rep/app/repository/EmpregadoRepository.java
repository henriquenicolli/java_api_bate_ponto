package com.rep.app.repository;

import com.rep.app.model.dto.EmpregadoDTO;

import java.util.List;

public interface EmpregadoRepository {

    EmpregadoDTO salvarEmpregado(EmpregadoDTO empregadoDTO);

    List<EmpregadoDTO> buscarEmpregado(String idEmpresa);
}
