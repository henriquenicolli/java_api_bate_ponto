package com.rep.app.controller;

import com.rep.app.mapper.RegistroPontoRequestMapper;
import com.rep.app.model.dto.RegistroPontoAtualSnapshotDTO;
import com.rep.app.model.dto.RegistroPontoDTO;
import com.rep.app.request.RegistroPontoRequest;
import com.rep.app.service.RegistroPontoSnapshotService;
import com.rep.app.services.RegistroPontoService;
import com.rep.app.util.DateUtil;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/rep/registroPonto")
public class RegistroPontoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistroPontoController.class);

    @Autowired
    private RegistroPontoService registroPontoService;

    @Autowired
    private RegistroPontoSnapshotService registroPontoSnapshotService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<RegistroPontoDTO> salvaRegistroPonto(@Valid @RequestBody RegistroPontoRequest registroPontoRequest) {

        LOGGER.info("inicio da chamada para salvar novo registro de ponto");

        final RegistroPontoDTO registroPontoDTO = RegistroPontoRequestMapper.INSTANCE.toDto(registroPontoRequest);

        return ResponseEntity.ok(registroPontoService.salvarRegistroPonto(registroPontoDTO));
    }

    @GetMapping(value = "/snapshot")
    public ResponseEntity<RegistroPontoAtualSnapshotDTO> getRegistroPontoAtualSnapshot() {

        LOGGER.info("get snapshot de ponto");

        RegistroPontoAtualSnapshotDTO registroPontoAtualSnapshotDTO = registroPontoSnapshotService.getRegistroPontoAtualSnapshot();

        LOGGER.info("finalizado chamada para snapshot de ponto");

        return ResponseEntity.ok(registroPontoAtualSnapshotDTO);
    }

    @GetMapping(value = "/{mesSelecionado}")
    public ResponseEntity<List<RegistroPontoDTO>> getRegistroPontoByMes(@PathVariable String mesSelecionado) {

        LOGGER.info("get registros de ponto por mes");

        List<RegistroPontoDTO> oldRegistroPontoDTOS = registroPontoService.findByMesMarcacaoPonto(DateUtil.sanitize(mesSelecionado));

        System.out.println("sucesso " + oldRegistroPontoDTOS);

        return ResponseEntity.ok(oldRegistroPontoDTOS);
    }

}
