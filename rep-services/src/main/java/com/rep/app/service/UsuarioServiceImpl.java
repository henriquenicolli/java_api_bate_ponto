package com.rep.app.service;

import com.rep.app.model.dto.UsuarioDTO;
import com.rep.app.repository.UsuarioRepository;
import com.rep.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {

        return usuarioRepository.salvarUsuario(usuarioDTO);
    }

}
