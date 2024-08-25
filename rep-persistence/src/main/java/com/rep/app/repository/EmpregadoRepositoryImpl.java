package com.rep.app.repository;

import com.rep.app.entity.EmpregadoEntity;
import com.rep.app.mapper.EmpregadoEntityMapper;
import com.rep.app.model.dto.EmpregadoDTO;
import com.rep.app.model.dto.HistoricoEmpregadoDTO;
import com.rep.app.model.enums.TipoOperacaoInslucaoAlteracao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class EmpregadoRepositoryImpl implements EmpregadoRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpregadoRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private HistoricoEmpregadoRepository historicoEmpregadoRepository;

    @Override
    @Transactional
    public EmpregadoDTO salvarEmpregado(final EmpregadoDTO empregadoDTO) {

        try {
            EmpregadoEntity empregadoEntity = EmpregadoEntityMapper.INSTANCE.toEntity(empregadoDTO);

            EmpregadoEntity empregadoSalvo = entityManager.merge(empregadoEntity);

            criaHistoricoEmpregado(empregadoSalvo, empregadoDTO.getIdUsuarioInclusaoAlteracao());

            return EmpregadoEntityMapper.INSTANCE.toDto(empregadoEntity);

        } catch (Exception e) {
            LOGGER.error("error while saving empregado", empregadoDTO, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<EmpregadoDTO> buscarEmpregado(final String idEmpresa) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmpregadoEntity> cq = cb.createQuery(EmpregadoEntity.class);
        Root<EmpregadoEntity> empregado = cq.from(EmpregadoEntity.class);
        cq.select(empregado);
        cq.where(cb.equal(empregado.get("empresa").get("idEmpresa"), idEmpresa));

        List<EmpregadoEntity> empregadoEntityList = entityManager.createQuery(cq).getResultList();

        return EmpregadoEntityMapper.INSTANCE.toDtoList(empregadoEntityList);
    }

    private void criaHistoricoEmpregado(final EmpregadoEntity empregadoSalvo, final String idUsuarioInclusaoAlteracao) {
        final HistoricoEmpregadoDTO historicoEmpregadoDTO = new HistoricoEmpregadoDTO();
        historicoEmpregadoDTO.setIdEmpregado(empregadoSalvo.getIdEmpregado());
        historicoEmpregadoDTO.setNumSeqRegistro(empregadoSalvo.getNumSeqRegistro());
        historicoEmpregadoDTO.setIdUsuarioInclusaoAlteracao(idUsuarioInclusaoAlteracao);
        historicoEmpregadoDTO.setTipoOperacao(TipoOperacaoInslucaoAlteracao.INCLUSAO.getTipoOperacao());
        historicoEmpregadoDTO.setDataHoraInclusaoAlteracao(LocalDateTime.now());
        historicoEmpregadoDTO.setCpfUsuarioInclusaoAlteracao("08791876974");

        historicoEmpregadoRepository.salvarHistoricoEmpregado(historicoEmpregadoDTO);
    }

}
