package com.rep.app.repository;

import com.rep.app.entity.UsuarioEntity;
import com.rep.app.mapper.UsuarioMapper;
import com.rep.app.model.dto.UsuarioDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public UsuarioDTO salvarUsuario(final UsuarioDTO usuarioDTO) {

        try {
            UsuarioEntity usuarioEntity = UsuarioMapper.INSTANCE.toEntity(usuarioDTO);

            entityManager.merge(usuarioEntity);

            return UsuarioMapper.INSTANCE.toDto(usuarioEntity);

        } catch (Exception e) {
            LOGGER.error("error while saving user", usuarioDTO, e);
            throw new RuntimeException(e);
        }
    }
}
