package com.rep.app.service;

import com.rep.app.entity.RegistroPontoEntity;
import com.rep.app.model.dto.OldRegistroPontoDTO;
//import com.rep.app.repository.RegistroPontoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Deprecated
@Service
public class OldRegistroPontoService {

    //@Autowired
    //private RegistroPontoRepository registroPontoRepository;

    private static final Logger logger = LoggerFactory.getLogger(OldRegistroPontoService.class);

    public boolean registrarPonto(final OldRegistroPontoDTO oldRegistroPontoDTO) {
        // TODO FIX ME
        //final var registroPontoEntity = RegistroPontoEntity.builder()
                //mock funcionario
                //.empregadoEntity(EmpregadoEntity.builder()
                //        .idFuncionario(1)
                //        .build())
                //.dataHoraRegistroPonto(registroPontoDTO.getDataHoraRegistroPonto())
                //.latitude(new BigDecimal(registroPontoDTO.getLatitude()))
                //.longitude(new BigDecimal(registroPontoDTO.getLongitude()))
                //.tipoRegistroPontoEntity(TipoRegistroPontoEntity.builder()
                //        .idTipoRegistroPonto(registroPontoDTO.getTipoRegistro().getCodigo())
                //        .build())
        //        .build();

        //registroPontoRepository.save(registroPontoEntity);

        return true;
    }

    public List<OldRegistroPontoDTO> getEspelhoPontoMes(final int mes) {
        List<OldRegistroPontoDTO> oldRegistroPontoDTOS = new ArrayList<>();
        //List<RegistroPontoEntity> entities = registroPontoRepository.findByMes(mes);

        //adicionaRegistroPonto(entities, registroPontoDTOS);

        return oldRegistroPontoDTOS;
    }

    private void adicionaRegistroPonto(List<RegistroPontoEntity> registroPontoEntities, List<OldRegistroPontoDTO> oldRegistroPontoDTO) {
        // TODO FIX ME
        registroPontoEntities.forEach(entity -> {
            //final var registroPontoDto = RegistroPontoDTO.builder()
                    //.dataHoraRegistroPonto(entity.getDataHoraRegistroPonto())
                    //.tipoRegistro(TipoRegistro.fromCodigo(entity.getTipoRegistroPontoEntity().getIdTipoRegistroPonto()))
        //            .build();

            oldRegistroPontoDTO.add(null);
        });
    }

}
