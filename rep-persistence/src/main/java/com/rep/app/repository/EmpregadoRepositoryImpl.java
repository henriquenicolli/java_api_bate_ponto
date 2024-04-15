package com.rep.app.repository;

import com.rep.app.entity.EmpregadoEntity;
import com.rep.app.mapper.EmpregadoMapper;
import com.rep.app.model.dto.EmpregadoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class EmpregadoRepositoryImpl implements EmpregadoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpregadoRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public EmpregadoDTO salvarEmpregado(final EmpregadoDTO empregadoDTO) {

        try {
            EmpregadoEntity empregadoEntity = EmpregadoMapper.INSTANCE.toEntity(empregadoDTO);


            entityManager.merge(empregadoEntity);

            return EmpregadoMapper.INSTANCE.toDto(empregadoEntity);

        } catch (Exception e) {
            LOGGER.error("error while saving empregado", empregadoDTO, e);
            throw new RuntimeException(e);
        }
    }

}
