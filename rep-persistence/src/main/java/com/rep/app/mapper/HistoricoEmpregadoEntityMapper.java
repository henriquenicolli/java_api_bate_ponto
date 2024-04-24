package com.rep.app.mapper;

import com.rep.app.entity.EmpregadoEntity;
import com.rep.app.entity.HistoricoEmpregadoEntity;
import com.rep.app.entity.UsuarioEntity;
import com.rep.app.model.dto.HistoricoEmpregadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoricoEmpregadoEntityMapper {

    HistoricoEmpregadoEntityMapper INSTANCE = Mappers.getMapper(HistoricoEmpregadoEntityMapper.class);

    //@Mapping(target = "idHistoricoEmpregado", source = "idHistoricoEmpregado")
    @Mapping(target = "numSeqRegistro", source = "numSeqRegistro")
    @Mapping(target = "cpfUsuarioInclusaoAlteracao", source = "cpfUsuarioInclusaoAlteracao")
    @Mapping(target = "tipoOperacao", source = "tipoOperacao")
    @Mapping(target = "dataHoraInclusaoAlteracao", source = "dataHoraInclusaoAlteracao")
    @Mapping(target = "empregado", source = "idEmpregado", qualifiedByName = "mapEmpregadoIdToEntity")
    @Mapping(target = "usuarioInclusaoAlteracao", source = "idUsuarioInclusaoAlteracao", qualifiedByName = "mapUsuarioIdToEntity")
    HistoricoEmpregadoEntity toEntity(HistoricoEmpregadoDTO dto);

    @Mapping(target = "idHistoricoEmpregado", source = "idHistoricoEmpregado")
    @Mapping(target = "numSeqRegistro", source = "numSeqRegistro")
    @Mapping(target = "cpfUsuarioInclusaoAlteracao", source = "cpfUsuarioInclusaoAlteracao")
    @Mapping(target = "tipoOperacao", source = "tipoOperacao")
    @Mapping(target = "dataHoraInclusaoAlteracao", source = "dataHoraInclusaoAlteracao")
    //@Mapping(target = "idEmpregado", source = "idEmpregado")
    //@Mapping(target = "idUsuarioInclusaoAlteracao", source = "usuarioInclusaoAlteracao")
    HistoricoEmpregadoDTO toDto(HistoricoEmpregadoEntity entity);

    @Named("mapEmpregadoIdToEntity")
    default EmpregadoEntity mapEmpregadoIdToEntity(final String idEmpregado) {
        final EmpregadoEntity empregado = new EmpregadoEntity();
        empregado.setIdEmpregado(idEmpregado);
        return empregado;
    }

    @Named("mapUsuarioIdToEntity")
    default UsuarioEntity mapUsuarioIdToEntity(final String idEmpregado) {
        final UsuarioEntity usuario = new UsuarioEntity();
        usuario.setIdUsuario(idEmpregado);
        return usuario;
    }

}
