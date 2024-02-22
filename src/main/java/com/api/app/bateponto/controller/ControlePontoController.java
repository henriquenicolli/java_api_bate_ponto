package com.api.app.bateponto.controller;

import com.api.app.bateponto.model.dto.ControlePontoDTO;
import com.api.app.bateponto.model.entity.RegistroPontoEntity;
import com.api.app.bateponto.repository.RegistroPontoRepository;
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
    private RegistroPontoRepository registroPontoRepository;

    @PostMapping(value = "/registrar")
    public ResponseEntity<String> registrarPonto(@RequestBody ControlePontoDTO controlePontoDTO) {

        System.out.println(controlePontoDTO);

        final var registroPontoEntity = RegistroPontoEntity.builder()
                .dataHoraRegistroPonto(controlePontoDTO.getDataHoraRegistroPonto())
                .latitude(controlePontoDTO.getLatitude())
                .longitude(controlePontoDTO.getLongitude())
                .build();

        registroPontoRepository.save(registroPontoEntity);

        return ResponseEntity.accepted().build();
    }


    @GetMapping(value = "/registros")
    public ResponseEntity<List<ControlePontoDTO>> findAll() throws Exception {
        List<RegistroPontoEntity> entities = registroPontoRepository.findAll();
        List<ControlePontoDTO> controlePontoDTOS = new ArrayList<>();

        entities.forEach( entity -> {
            final var registroPontoDto = ControlePontoDTO.builder()
                .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                .build();

            controlePontoDTOS.add(registroPontoDto);
            }
        );

        System.out.println("sucesso " + entities);

        return ResponseEntity.ok(controlePontoDTOS);
    }

}
