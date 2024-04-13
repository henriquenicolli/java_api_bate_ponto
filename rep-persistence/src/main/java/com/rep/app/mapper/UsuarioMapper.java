package com.rep.app.mapper;

import com.rep.app.entity.UsuarioEntity;
import com.rep.app.model.dto.UsuarioDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(target = "idUsuario", ignore = true)
    @Mapping(target = "userLogin", source = "userLogin")
    @Mapping(target = "userPassword", source = "userPassword")
    @Mapping(target = "userEmail", source = "userEmail")
    UsuarioEntity toEntity(UsuarioDTO dto);

    @Mapping(target = "userLogin", source = "userLogin")
    @Mapping(target = "userPassword", source = "userPassword")
    @Mapping(target = "userEmail", source = "userEmail")
    UsuarioDTO toDto(UsuarioEntity entity);

}
