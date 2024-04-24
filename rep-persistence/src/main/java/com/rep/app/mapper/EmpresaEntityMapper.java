package com.rep.app.mapper;

import com.rep.app.entity.EmpresaEntity;
import com.rep.app.model.dto.EmpresaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmpresaEntityMapper {

    EmpresaEntityMapper INSTANCE = Mappers.getMapper(EmpresaEntityMapper.class);

    @Mapping(target = "idEmpresa", ignore = true)
    @Mapping(target = "nomeEmpresa", source = "nomeEmpresa")
    @Mapping(target = "razaoSocial", source = "razaoSocial")
    @Mapping(target = "tipoIdefEmpregador", source = "tipoIdefEmpregador")
    @Mapping(target = "cnpj", source = "cnpj")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "codIdefCei", source = "codIdefCei")
    @Mapping(target = "codIdefCaepf", source = "codIdefCaepf")
    @Mapping(target = "codIdefCno", source = "codIdefCno")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "usuarioInclusaoAlteracao", source = "usuarioInclusaoAlteracao")
    EmpresaEntity toEntity(EmpresaDTO dto);

    @Mapping(target = "idEmpresa", source = "idEmpresa")
    @Mapping(target = "numSeqRegistro", source = "numSeqRegistro")
    @Mapping(target = "nomeEmpresa", source = "nomeEmpresa")
    @Mapping(target = "razaoSocial", source = "razaoSocial")
    @Mapping(target = "tipoIdefEmpregador", source = "tipoIdefEmpregador")
    @Mapping(target = "cnpj", source = "cnpj")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "codIdefCei", source = "codIdefCei")
    @Mapping(target = "codIdefCaepf", source = "codIdefCaepf")
    @Mapping(target = "codIdefCno", source = "codIdefCno")
    @Mapping(target = "dataHoraInclusaoAlteracao", source = "dataHoraInclusaoAlteracao")
    @Mapping(target = "tipoOperacaoInclusaoAlteracao", source = "tipoOperacaoInclusaoAlteracao")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "usuarioInclusaoAlteracao", source = "usuarioInclusaoAlteracao")
    EmpresaDTO toDto(EmpresaEntity entity);

}
