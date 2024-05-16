package com.rep.app.service;

import com.rep.app.model.dto.EmpregadoDTO;
import com.rep.app.repository.EmpregadoRepository;
import com.rep.app.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregadoServiceImpl implements EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Override
    public EmpregadoDTO salvarEmpregado(EmpregadoDTO empregadoDTO) {
        return empregadoRepository.salvarEmpregado(empregadoDTO);
    }

    @Override
    public List<EmpregadoDTO> buscarEmpregado(String idEmpresa) {
        return empregadoRepository.buscarEmpregado(idEmpresa);
    }

}
