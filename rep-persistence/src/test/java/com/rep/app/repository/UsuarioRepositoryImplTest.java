package com.rep.app.repository;

import com.rep.app.entity.UsuarioEntity;
import com.rep.app.mapper.UsuarioMapper;
import com.rep.app.model.dto.UsuarioDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UsuarioRepositoryImplTest {

    @InjectMocks
    private UsuarioRepositoryImpl usuarioRepository;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUserLogin("testLogin");
        usuarioDTO.setUserPassword("testPassword");
        usuarioDTO.setUserEmail("testEmail");

        UsuarioEntity usuarioEntity = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);

        when(entityManager.merge(any(UsuarioEntity.class))).thenReturn(usuarioEntity);

        usuarioRepository.salvarUsuario(usuarioDTO);

        verify(entityManager, times(1)).merge(any(UsuarioEntity.class));
    }
}
