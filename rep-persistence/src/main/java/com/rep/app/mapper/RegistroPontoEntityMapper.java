package com.rep.app.mapper;

import com.rep.app.entity.*;
import com.rep.app.model.dto.RegistroPontoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
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

    @Mapping(target = "coletorRegistro", source = "coletorRegistro", qualifiedByName = "mapColetorRegistro")
    @Mapping(target = "tipoMarcacao", source = "tipoMarcacao", qualifiedByName = "mapTipoMarcacao")
    @Mapping(target = "fonteMarcacao", source = "fonteMarcacao", qualifiedByName = "mapFonteMarcacao")
    @Mapping(target = "empregado", source = "empregado", qualifiedByName = "mapEmpregado")
    void updateEntityFromDto(RegistroPontoDTO dto, @MappingTarget RegistroPontoEntity entity);


    @Named("mapColetorRegistroToInteger")
    default Integer mapColetorRegistroToInteger(ColetorRegistroEntity entity) {
        return entity != null ? entity.getCodIdefColetorRegistro() : null;
    }

    @Named("mapTipoMarcacaoToString")
    default String mapTipoMarcacaoToString(TipoMarcacaoEntity entity) {
        return entity != null ? entity.getCodTipoMarcacao() : null;
    }

    @Named("mapFonteMarcacaoToString")
    default String mapFonteMarcacaoToString(FonteMarcacaoEntity entity) {
        return entity != null ? entity.getCodFonteMarcacao() : null;
    }

    @Named("mapEmpregadoToString")
    default String mapEmpregadoToString(EmpregadoEntity entity) {
        return entity != null ? entity.getIdEmpregado() : null;
    }

    @Named("mapColetorRegistro")
    default ColetorRegistroEntity mapColetorRegistro(Integer value) {
        final ColetorRegistroEntity entity = new ColetorRegistroEntity();
        entity.setCodIdefColetorRegistro(value);
        return entity;
    }

    @Named("mapTipoMarcacao")
    default TipoMarcacaoEntity mapTipoMarcacao(String value) {
        final TipoMarcacaoEntity tipoMarcacaoEntity = new TipoMarcacaoEntity();
        tipoMarcacaoEntity.setCodTipoMarcacao(value);
        return tipoMarcacaoEntity;
    }

    @Named("mapFonteMarcacao")
    default FonteMarcacaoEntity mapFonteMarcacao(String value) {
        final FonteMarcacaoEntity fonteMarcacaoEntity = new FonteMarcacaoEntity();
        fonteMarcacaoEntity.setCodFonteMarcacao(value);
        return fonteMarcacaoEntity;
    }

    @Named("mapEmpregado")
    default EmpregadoEntity mapEmpregado(String value) {
        final EmpregadoEntity empregadoEntity = new EmpregadoEntity();
        empregadoEntity.setIdEmpregado(value);
        return empregadoEntity;
    }

}
