package com.bateponto.app.service;

import com.bateponto.app.entity.FuncionarioEntity;
import com.bateponto.app.entity.RegistroPontoEntity;
import com.bateponto.app.entity.TipoRegistroPontoEntity;
import com.bateponto.app.model.dto.RegistroPontoDTO;
import com.bateponto.app.model.enums.TipoRegistro;
import com.bateponto.app.repository.RegistroPontoRepository;
import com.bateponto.app.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrarPontoService {

    @Autowired
    private RegistroPontoRepository registroPontoRepository;

    private static final Logger logger = LoggerFactory.getLogger(RegistrarPontoService.class);

    public boolean registrarPonto(final RegistroPontoDTO registroPontoDTO) {
        final var registroPontoEntity = RegistroPontoEntity.builder()
                //mock funcionario
                .funcionarioEntity(FuncionarioEntity.builder()
                        .idFuncionario(1)
                        .build())
                .dataHoraRegistroPonto(registroPontoDTO.getDataHoraRegistroPonto())
                .latitude(new BigDecimal(registroPontoDTO.getLatitude()))
                .longitude(new BigDecimal(registroPontoDTO.getLongitude()))
                .tipoRegistroPontoEntity(TipoRegistroPontoEntity.builder()
                        .idTipoRegistroPonto(registroPontoDTO.getTipoRegistro().getCodigo())
                        .build())
                .build();

        registroPontoRepository.save(registroPontoEntity);

        return true;
    }

    public List<RegistroPontoDTO> getEspelhoPontoMes(final String mes) {
        List<RegistroPontoDTO> registroPontoDTOS = new ArrayList<>();
        List<RegistroPontoEntity> entities = registroPontoRepository.findByMes(DateUtil.getMes(mes));

        adicionaRegistroPonto(entities, registroPontoDTOS);

        return registroPontoDTOS;
    }

    private void adicionaRegistroPonto(List<RegistroPontoEntity> registroPontoEntities, List<RegistroPontoDTO> registroPontoDTO) {
        registroPontoEntities.forEach(entity -> {
            final var registroPontoDto = RegistroPontoDTO.builder()
                    .dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    .tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistroPontoEntity().getIdTipoRegistroPonto()))
                    .build();

            registroPontoDTO.add(registroPontoDto);
        });
    }

}
