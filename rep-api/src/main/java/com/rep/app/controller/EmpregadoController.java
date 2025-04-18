package com.rep.app.controller;

import com.rep.app.model.dto.EmpregadoDTO;
import com.rep.app.services.EmpregadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/rep/empregado")
public class EmpregadoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpregadoController.class);

    @Autowired
    private EmpregadoService empregadoService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<EmpregadoDTO> salvaEmpregado(@RequestBody EmpregadoDTO empregadoDTO) {

        LOGGER.info("inicio da chamada para salvar novo empregado");

        return ResponseEntity.ok(empregadoService.salvarEmpregado(empregadoDTO));
    }

    @GetMapping(value = "/buscar/{id_empresa}")
    public ResponseEntity<List<EmpregadoDTO>> buscarEmpregado(@PathVariable String id_empresa) {

        LOGGER.info("inicio da chamada para buscar empregado");

        return ResponseEntity.ok(empregadoService.buscarEmpregado(id_empresa));
    }

}
