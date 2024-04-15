package com.rep.app.mapper;

import com.rep.app.entity.UsuarioEntity;
import com.rep.app.model.dto.UsuarioDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioMapperTest {

    private final UsuarioMapper mapper = UsuarioMapper.INSTANCE;

    @Test
    public void testToEntity() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUserLogin("testLogin");
        dto.setUserPassword("testPassword");
        dto.setUserEmail("testEmail");

        UsuarioEntity entity = mapper.toEntity(dto);

        assertThat(entity.getUserLogin()).isEqualTo(dto.getUserLogin());
        assertThat(entity.getUserPassword()).isEqualTo(dto.getUserPassword());
        assertThat(entity.getUserEmail()).isEqualTo(dto.getUserEmail());
    }

    @Test
    public void testToDto() {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setUserLogin("testLogin");
        entity.setUserPassword("testPassword");
        entity.setUserEmail("testEmail");
        entity.setIdUsuario("testId");

        UsuarioDTO dto = mapper.toDto(entity);

        assertThat(dto.getUserLogin()).isEqualTo(entity.getUserLogin());
        assertThat(dto.getUserPassword()).isEqualTo(entity.getUserPassword());
        assertThat(dto.getUserEmail()).isEqualTo(entity.getUserEmail());
        assertThat(dto.getIdUsuario()).isEqualTo(entity.getIdUsuario());
    }
}
