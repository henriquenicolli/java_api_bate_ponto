package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_USUARIO")
@NamedQueries({
        @NamedQuery(name = UsuarioEntity.QUERY_FIND_USUARIO_BY_USERNAME,
                query = "SELECT u FROM UsuarioEntity u WHERE u.userLogin = :username")
})
public class UsuarioEntity {

    public static final String QUERY_FIND_USUARIO_BY_USERNAME = "QUERY_FIND_USUARIO_BY_USERNAME";

    @Id
    @Column(name = "id_usuario", updatable = false, nullable = false)
    private String idUsuario;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @PrePersist
    public void generateId() {
        idUsuario = UUID.randomUUID().toString();
    }

}
