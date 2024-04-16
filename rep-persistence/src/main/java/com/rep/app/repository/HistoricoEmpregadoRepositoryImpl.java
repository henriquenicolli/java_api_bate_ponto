package com.rep.app.repository;

import com.rep.app.entity.HistoricoEmpregadoEntity;
import com.rep.app.mapper.HistoricoEmpregadoMapper;
import com.rep.app.model.dto.HistoricoEmpregadoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HistoricoEmpregadoRepositoryImpl implements HistoricoEmpregadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public HistoricoEmpregadoDTO salvarHistoricoEmpregado(final HistoricoEmpregadoDTO historicoEmpregadoDTO) {

        HistoricoEmpregadoEntity historicoEmpregadoEntity = HistoricoEmpregadoMapper.INSTANCE.toEntity(historicoEmpregadoDTO);

        entityManager.merge(historicoEmpregadoEntity);

        return HistoricoEmpregadoMapper.INSTANCE.toDto(historicoEmpregadoEntity);

    }
}
