package com.rep.app.mapper;

import com.rep.app.model.dto.UsuarioDTO;
import com.rep.app.request.UsuarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioRequestMapper {

    UsuarioRequestMapper INSTANCE = Mappers.getMapper(UsuarioRequestMapper.class);

    @Mapping(target = "userLogin", source = "login")
    @Mapping(target = "userPassword", source = "senha")
    @Mapping(target = "userEmail", source = "email")
    UsuarioDTO toDto(UsuarioRequest request);

}
