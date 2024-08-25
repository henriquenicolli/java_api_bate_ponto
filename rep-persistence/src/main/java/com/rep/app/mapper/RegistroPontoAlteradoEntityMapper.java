package com.rep.app.mapper;

import com.rep.app.mapper.commons.RegistroPontoCommonsMapper;
import com.rep.app.entity.RegistroPontoEntity;
import com.rep.app.model.dto.RegistroPontoDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = RegistroPontoCommonsMapper.class)
public abstract class RegistroPontoAlteradoEntityMapper {

    public static final RegistroPontoAlteradoEntityMapper INSTANCE = Mappers.getMapper(RegistroPontoAlteradoEntityMapper.class);

    @Mapping(target = "horaMarcacaoPonto", ignore = true)
    @Mapping(target = "coletorRegistro", source = "coletorRegistro", qualifiedByName = "mapColetorRegistro")
    @Mapping(target = "tipoMarcacao", source = "tipoMarcacao", qualifiedByName = "mapTipoMarcacao")
    @Mapping(target = "fonteMarcacao", source = "fonteMarcacao", qualifiedByName = "mapFonteMarcacao")
    @Mapping(target = "empregado", source = "empregado", qualifiedByName = "mapEmpregado")
    @Mapping(target = "fusoHorarioRegistro", defaultValue = "GMT-3")
    @Mapping(target = "registroAlterado", defaultValue = "true")
    @Mapping(target = "registroAlteradoAprovacao", defaultValue = "false")
    public abstract void updateEntityFromDto(RegistroPontoDTO dto, @MappingTarget RegistroPontoEntity entity);

    @AfterMapping
    protected void afterMapping(RegistroPontoDTO dto, @MappingTarget RegistroPontoEntity entity) {
       entity.setHoraMarcacaoPontoOriginal(entity.getHoraMarcacaoPonto());
       entity.setHoraMarcacaoPonto(dto.getHoraMarcacaoPonto());
    }

}
