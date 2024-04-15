package com.rep.app.repository;

import com.rep.app.entity.EmpresaEntity;
import com.rep.app.mapper.EmpresaMapper;
import com.rep.app.model.dto.EmpresaDTO;
import com.rep.app.model.enums.TipoOperacaoInslucaoAlteracao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public class EmpresaRepositoryImpl implements EmpresaRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpresaRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public EmpresaDTO salvarEmpresa(final EmpresaDTO empresaDTO) {

        try {
            EmpresaEntity empresaEntity = EmpresaMapper.INSTANCE.toEntity(empresaDTO);
            empresaEntity.setDataHoraInclusaoAlteracao(LocalDateTime.now());
            empresaEntity.setTipoOperacaoInclusaoAlteracao(TipoOperacaoInslucaoAlteracao.INCLUSAO);

            entityManager.merge(empresaEntity);

            return EmpresaMapper.INSTANCE.toDto(empresaEntity);

        } catch (Exception e) {
            LOGGER.error("error while saving empresa", empresaDTO, e);
            throw new RuntimeException(e);
        }
    }

}
