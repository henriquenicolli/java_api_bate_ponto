package com.rep.app.mapper;

import com.rep.app.mapper.commons.RegistroPontoCommonsMapper;
import com.rep.app.entity.RegistroPontoEntity;
import com.rep.app.model.dto.RegistroPontoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(uses = RegistroPontoCommonsMapper.class)
public interface RegistroPontoEntityMapper {

    RegistroPontoEntityMapper INSTANCE = Mappers.getMapper(RegistroPontoEntityMapper.class);

    @Mapping(target = "dataMarcacaoPonto", source = "dataMarcacaoPonto")
    @Mapping(target = "horaMarcacaoPonto", source = "horaMarcacaoPonto")
    @Mapping(target = "fusoHorarioMarcacao", source = "fusoHorarioMarcacao")
    @Mapping(target = "fusoHorarioRegistro", source = "fusoHorarioRegistro")
    @Mapping(target = "marcacaoOnline", source = "marcacaoOnline")
    @Mapping(target = "cpfFuncionario", source = "cpfFuncionario")
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    @Mapping(target = "motivoMarcacao", source = "motivoMarcacao")
    @Mapping(target = "coletorRegistro", source = "coletorRegistro", qualifiedByName = "mapColetorRegistro")
    @Mapping(target = "tipoMarcacao", source = "tipoMarcacao", qualifiedByName = "mapTipoMarcacao")
    @Mapping(target = "fonteMarcacao", source = "fonteMarcacao", qualifiedByName = "mapFonteMarcacao")
    @Mapping(target = "empregado", source = "empregado", qualifiedByName = "mapEmpregado")
    @Mapping(target = "registroAlterado", defaultValue = "0")
    @Mapping(target = "registroAlteradoAprovacao", defaultValue = "0")
    @Mapping(target = "excluido", defaultValue = "0")
    @Mapping(target = "registroExcluidoAprovacao", defaultValue = "0")
    RegistroPontoEntity toEntity(RegistroPontoDTO dto);

    @Mapping(target = "dataMarcacaoPonto", source = "dataMarcacaoPonto")
    @Mapping(target = "horaMarcacaoPonto", source = "horaMarcacaoPonto")
    @Mapping(target = "fusoHorarioMarcacao", source = "fusoHorarioMarcacao")
    @Mapping(target = "fusoHorarioRegistro", source = "fusoHorarioRegistro")
    @Mapping(target = "marcacaoOnline", source = "marcacaoOnline")
    @Mapping(target = "cpfFuncionario", source = "cpfFuncionario")
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    @Mapping(target = "motivoMarcacao", source = "motivoMarcacao")
    @Mapping(target = "coletorRegistro", source = "coletorRegistro", qualifiedByName = "mapColetorRegistroToInteger")
    @Mapping(target = "tipoMarcacao", source = "tipoMarcacao", qualifiedByName = "mapTipoMarcacaoToString")
    @Mapping(target = "fonteMarcacao", source = "fonteMarcacao", qualifiedByName = "mapFonteMarcacaoToString")
    @Mapping(target = "empregado", source = "empregado", qualifiedByName = "mapEmpregadoToString")
    RegistroPontoDTO toDto(RegistroPontoEntity registroPontoEntity);

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
    @Mapping(target = "empregado", source = "empregado")
    List<RegistroPontoDTO> toDto(List<RegistroPontoEntity> entities);






}
