package com.rep.app.repository;

import com.rep.app.model.dto.UsuarioDTO;
import org.springframework.security.core.userdetails.User;

public interface UsuarioRepository {

    UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO);

    User findByUsername(String username);
}
