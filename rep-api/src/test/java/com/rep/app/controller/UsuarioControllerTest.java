package com.rep.app.controller;

import com.rep.app.mapper.UsuarioRequestMapper;
import com.rep.app.model.dto.UsuarioDTO;
import com.rep.app.request.UsuarioRequest;
import com.rep.app.services.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvaUsuario() {
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setLogin("testLogin");
        usuarioRequest.setSenha("testPassword");
        usuarioRequest.setEmail("testEmail");

        UsuarioDTO usuarioDTO = UsuarioRequestMapper.INSTANCE.toDto(usuarioRequest);

        when(usuarioService.salvarUsuario(any(UsuarioDTO.class))).thenReturn(usuarioDTO);

        ResponseEntity<UsuarioDTO> response = usuarioController.salvaUsuario(usuarioRequest);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(usuarioDTO, response.getBody());

        verify(usuarioService, times(1)).salvarUsuario(any(UsuarioDTO.class));
    }
}