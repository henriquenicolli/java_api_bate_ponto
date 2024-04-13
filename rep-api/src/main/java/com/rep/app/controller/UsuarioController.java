package com.rep.app.controller;

import com.rep.app.model.dto.UsuarioDTO;
import com.rep.app.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1/rep/usuario")
public class UsuarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<UsuarioDTO> salvaUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        LOGGER.info("inicio da chamada para salvar novo usuario");

        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
    }


}
