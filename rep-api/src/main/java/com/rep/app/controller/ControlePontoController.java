package com.rep.app.controller;

import com.rep.app.model.dto.OldRegistroPontoDTO;
import com.rep.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.rep.app.service.OldRegistroPontoService;
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
    private OldRegistroPontoService oldRegistroPontoService;

    @Autowired
    private RegistroPontoSnapshotService registroPontoSnapshotService;

    @PostMapping(value = "/registrar")
    public ResponseEntity<String> registrarPonto(@RequestBody OldRegistroPontoDTO oldRegistroPontoDTO) {

        LOGGER.info("inicio da chamada para registro de ponto");

        oldRegistroPontoService.registrarPonto(oldRegistroPontoDTO);

        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/registros/{mesSelecionado}")
    public ResponseEntity<List<OldRegistroPontoDTO>> getEspelhoPontoByMes(@PathVariable String mesSelecionado) {

        LOGGER.info("inicio da chamada de registros de ponto por mes");

        List<OldRegistroPontoDTO> oldRegistroPontoDTOS = oldRegistroPontoService.getEspelhoPontoMes(DateUtil.sanitize(mesSelecionado));

        System.out.println("sucesso " + oldRegistroPontoDTOS);

        return ResponseEntity.ok(oldRegistroPontoDTOS);
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
