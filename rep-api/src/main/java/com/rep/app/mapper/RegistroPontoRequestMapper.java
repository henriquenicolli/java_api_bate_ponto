package com.rep.app.mapper;

import com.rep.app.model.dto.RegistroPontoDTO;
import com.rep.app.request.RegistroPontoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistroPontoRequestMapper {

    RegistroPontoRequestMapper INSTANCE = Mappers.getMapper(RegistroPontoRequestMapper.class);

    @Mapping(target = "dataMarcacaoPonto", source = "dataMarcacaoPonto")
    @Mapping(target = "horaMarcacaoPonto", source = "horaMarcacaoPonto")
    @Mapping(target = "fusoHorarioMarcacao", source = "fusoHorarioMarcacao")
    @Mapping(target = "fusoHorarioRegistro", source = "fusoHorarioRegistro")
    @Mapping(target = "marcacaoOnline", source = "marcacaoOnline")
    @Mapping(target = "cpfFuncionario", source = "cpfFuncionario")
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    @Mapping(target = "motivoMarcacao", source = "motivoMarcacao")
    @Mapping(target = "coletorRegistro", source = "coletorRegistro")
    @Mapping(target = "tipoMarcacao", source = "tipoMarcacao")
    @Mapping(target = "fonteMarcacao", source = "fonteMarcacao")
    @Mapping(target = "empregado", source = "idEmpregado")
    RegistroPontoDTO toDto(RegistroPontoRequest request);

}
