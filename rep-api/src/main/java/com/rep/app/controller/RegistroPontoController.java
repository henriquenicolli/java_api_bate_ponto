package com.rep.app.controller;

import com.rep.app.mapper.RegistroPontoRequestMapper;
import com.rep.app.model.dto.RegistroPontoDTO;
import com.rep.app.request.RegistroPontoRequest;
import com.rep.app.services.RegistroPontoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/rep/registroPonto")
public class RegistroPontoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistroPontoController.class);

    @Autowired
    private RegistroPontoService registroPontoService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<RegistroPontoDTO> salvaRegistroPonto(@Valid @RequestBody RegistroPontoRequest registroPontoRequest) {

        LOGGER.info("inicio da chamada para salvar novo registro de ponto");

        final RegistroPontoDTO registroPontoDTO = RegistroPontoRequestMapper.INSTANCE.toDto(registroPontoRequest);

        return ResponseEntity.ok(registroPontoService.salvarRegistroPonto(registroPontoDTO));
    }

}
