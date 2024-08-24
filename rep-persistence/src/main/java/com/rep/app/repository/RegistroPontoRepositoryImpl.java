package com.rep.app.repository;

import com.rep.app.mapper.RegistroPontoAlteradoEntityMapper;
import com.rep.app.mapper.RegistroPontoEntityMapper;
import com.rep.app.entity.RegistroPontoEntity;
import com.rep.app.model.dto.RegistroPontoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.rep.app.entity.RegistroPontoEntity.*;

@Repository
public class RegistroPontoRepositoryImpl implements RegistroPontoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<RegistroPontoDTO> findByDataInicioAndDataFim(LocalDate dataInicio, LocalDate dataFim) {
        List<RegistroPontoEntity> entities = entityManager.createNamedQuery(QUERY_FIND_BY_DATA_INICIO_AND_DATA_FIM, RegistroPontoEntity.class)
                .setParameter("dataInicio", dataInicio)
                .setParameter("dataFim", dataFim)
                .getResultList();

        return RegistroPontoEntityMapper.INSTANCE.toDto(entities);
    }

    @Override
    @Transactional
    public List<RegistroPontoDTO> findByMesMarcacaoPonto(int mesMarcacaoPonto) {
        List<RegistroPontoEntity> entities = entityManager.createNamedQuery(QUERY_FIND_BY_MES, RegistroPontoEntity.class)
                .setParameter("mes", mesMarcacaoPonto)
                .getResultList();

        return RegistroPontoEntityMapper.INSTANCE.toDto(entities);
    }

    public RegistroPontoEntity findByNumeroSequencial(int numeroSequencial) {
        final RegistroPontoEntity entity = entityManager.createNamedQuery(QUERY_FIND_BY_NUMERO_SEQUENCIAL, RegistroPontoEntity.class)
                .setParameter("numeroSequencial", numeroSequencial)
                .getSingleResult();

        return entity;
    }

    @Override
    @Transactional
    public void updateRegistroPonto(RegistroPontoDTO registroAtualizado) {

        RegistroPontoEntity entity = findByNumeroSequencial(registroAtualizado.getNumSeqRegistro());

        entity.setHoraMarcacaoPontoOriginal(entity.getHoraMarcacaoPonto());

        RegistroPontoAlteradoEntityMapper.INSTANCE.updateEntityFromDto(registroAtualizado, entity);

        entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void deleteRegistroPonto(int numSeqRegistro) {
        RegistroPontoEntity entity = findByNumeroSequencial(numSeqRegistro);
        entity.setExcluido(true);
        entityManager.merge(entity);
    }

    @Override
    @Transactional
    public RegistroPontoDTO salvarRegistroPonto(RegistroPontoDTO registroPontoDTO) {

        RegistroPontoEntity ultimoRegistro = consultarUltimoRegistro(registroPontoDTO.getEmpregado());

        int numeroSequencialEntradaSaida;
        if (ultimoRegistro == null || "S".equals(ultimoRegistro.getTipoMarcacao().getCodTipoMarcacao())) {
            // Se o último registro for uma SAIDA ou não houver registro anterior, este é um novo par
            numeroSequencialEntradaSaida = getNumeroSequencial(QUERY_FIND_MAX_ES_NUMERO_SEQUENCIAL) + 1;
        } else {
            // Se o último registro for uma ENTRADA, continuar com o mesmo número sequencial
            numeroSequencialEntradaSaida = getNumeroSequencial(QUERY_FIND_MAX_ES_NUMERO_SEQUENCIAL);
        }

        RegistroPontoEntity registroPontoEntity = RegistroPontoEntityMapper.INSTANCE.toEntity(registroPontoDTO);
        registroPontoEntity.setDataHoraInclusaoRegistro(LocalDateTime.now());
        registroPontoEntity.setFusoHorarioRegistro("America/Sao_Paulo");
        registroPontoEntity.setHashRegistro("hash".getBytes());
        registroPontoEntity.setNumSeqRegistro(getNumeroSequencial(QUERY_FIND_MAX_NUMERO_SEQUENCIAL) + 1);
        registroPontoEntity.setNumSeqEsRegistro(numeroSequencialEntradaSaida);


        entityManager.persist(registroPontoEntity);

        return RegistroPontoEntityMapper.INSTANCE.toDto(registroPontoEntity);
    }

    //todo transformar em um trigger?
    public int getNumeroSequencial(String query) {
        Integer maxNumeroSequencial = (Integer) entityManager.createNamedQuery(query)
                .getSingleResult();
        return maxNumeroSequencial != null ? maxNumeroSequencial : 0;
    }

    private RegistroPontoEntity consultarUltimoRegistro(String funcionario) {
        return entityManager.createNamedQuery(QUERY_FIND_LAST_REGISTRO_PONMTO_ENTITY_BY_FUNCIONARIO, RegistroPontoEntity.class)
                .setParameter("id_empregado", funcionario)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

}
