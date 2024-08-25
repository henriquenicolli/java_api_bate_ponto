package com.rep.app.repository;

import com.rep.app.entity.UsuarioEntity;
import com.rep.app.mapper.UsuarioEntityMapper;
import com.rep.app.model.dto.UsuarioDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public UsuarioDTO salvarUsuario(final UsuarioDTO usuarioDTO) {

        try {
            final UsuarioEntity usuarioEntity = UsuarioEntityMapper.INSTANCE.toEntity(usuarioDTO);

            final String hashedPassword = BCrypt.hashpw(usuarioDTO.getUserPassword(), BCrypt.gensalt());
            usuarioEntity.setUserPassword(hashedPassword);

            entityManager.merge(usuarioEntity);

            return UsuarioEntityMapper.INSTANCE.toDto(usuarioEntity);

        } catch (Exception e) {
            LOGGER.error("error while saving user", usuarioDTO, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public User findByUsername(final String username) {
        UsuarioEntity usuarioEntity = entityManager.createNamedQuery(UsuarioEntity.QUERY_FIND_USUARIO_BY_USERNAME, UsuarioEntity.class)
                .setParameter("username", username)
                .getSingleResult();

        return new User(usuarioEntity.getUserLogin(), usuarioEntity.getUserPassword(), new ArrayList<>());
    }
}
