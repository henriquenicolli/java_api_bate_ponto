package com.rep.app.controller;

import com.rep.app.model.dto.EmpresaDTO;
import com.rep.app.services.EmpresaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/rep/empresa")
public class EmpresaController {


    private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaController.class);

    @Autowired
    private EmpresaService empresaService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<EmpresaDTO> salvaEmpresa(@RequestBody EmpresaDTO empresaDTO) {

        LOGGER.info("inicio da chamada para salvar nova empresa");

        return ResponseEntity.ok(empresaService.salvarEmpresa(empresaDTO));
    }

}
