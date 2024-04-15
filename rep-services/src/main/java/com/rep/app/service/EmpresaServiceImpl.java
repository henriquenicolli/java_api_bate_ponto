package com.rep.app.service;

import com.rep.app.model.dto.EmpresaDTO;
import com.rep.app.repository.EmpresaRepository;
import com.rep.app.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public EmpresaDTO salvarEmpresa(EmpresaDTO empresaDTO) {
        return empresaRepository.salvarEmpresa(empresaDTO);
    }

}
