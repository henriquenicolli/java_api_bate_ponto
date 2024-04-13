package com.rep.app.controller;

import com.rep.app.model.dto.RegistroPontoDTO;
import com.rep.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.rep.app.service.RegistroPontoService;
import com.rep.app.service.RegistroPontoSnapshotService;
import com.rep.app.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Deprecated
@CrossOrigin
@RestController
@RequestMapping("/v1/rep")
public class ControlePontoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControlePontoController.class);

    @Autowired
    private RegistroPontoService registroPontoService;

    @Autowired
    private RegistroPontoSnapshotService registroPontoSnapshotService;

    @PostMapping(value = "/registrar")
    public ResponseEntity<String> registrarPonto(@RequestBody RegistroPontoDTO registroPontoDTO) {

        LOGGER.info("inicio da chamada para registro de ponto");

        registroPontoService.registrarPonto(registroPontoDTO);

        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/registros/{mesSelecionado}")
    public ResponseEntity<List<RegistroPontoDTO>> getEspelhoPontoByMes(@PathVariable String mesSelecionado) {

        LOGGER.info("inicio da chamada de registros de ponto por mes");

        List<RegistroPontoDTO> registroPontoDTOS = registroPontoService.getEspelhoPontoMes(DateUtil.sanitize(mesSelecionado));

        System.out.println("sucesso " + registroPontoDTOS);

        return ResponseEntity.ok(registroPontoDTOS);
    }

    @GetMapping(value = "/registros/atual/snapshot")
    public ResponseEntity<RegistroPontoAtualSnapshotDTO> getRegistroPontoAtualSnapshot() {

        LOGGER.info("inicio da chamada de snapshot de ponto");

        RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO = registroPontoSnapshotService
                .getRegistroPontoAtualSnapshot();

        LOGGER.info("finalizado chamada para snapshot de ponto");

        return ResponseEntity.ok(registroPontoAtualSnapshotDTO);
    }

}
