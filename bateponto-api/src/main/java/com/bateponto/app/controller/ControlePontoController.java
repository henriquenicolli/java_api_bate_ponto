package com.bateponto.app.controller;

import com.bateponto.app.model.dto.RegistroPontoDTO;
import com.bateponto.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.bateponto.app.service.RegistrarPontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/bateponto")
public class ControlePontoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControlePontoController.class);

    @Autowired
    private RegistrarPontoService registrarPontoService;

    @PostMapping(value = "/registrar")
    public ResponseEntity<String> registrarPonto(@RequestBody RegistroPontoDTO registroPontoDTO) {

        System.out.println(registroPontoDTO);

        registrarPontoService.registrarPonto(registroPontoDTO);

        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/registros/{mesSelecionado}")
    public ResponseEntity<List<RegistroPontoDTO>> getEspelhoPontoByMes(@PathVariable String mesSelecionado) {

        List<RegistroPontoDTO> registroPontoDTOS = registrarPontoService.getEspelhoPontoMes(mesSelecionado);

        System.out.println("sucesso " + registroPontoDTOS);

        return ResponseEntity.ok(registroPontoDTOS);
    }

    @GetMapping(value = "/registros/atual/snapshot")
    public ResponseEntity<RegistroPontoAtualSnapshotDTO> getRegistroPontoAtualSnapshot() {

        RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO = registrarPontoService
                .getRegistroPontoAtualSnapshot();

        return ResponseEntity.ok(registroPontoAtualSnapshotDTO);
    }

}
