package com.rep.app.controller;

import com.rep.app.mapper.UsuarioRequestMapper;
import com.rep.app.model.dto.UsuarioDTO;
import com.rep.app.request.UsuarioRequest;
import com.rep.app.services.UsuarioService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UsuarioDTO> salvaUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {

        LOGGER.info("inicio da chamada para salvar novo usuario");

        final UsuarioDTO usuario = UsuarioRequestMapper.INSTANCE.toDto(usuarioRequest);

        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }

}
