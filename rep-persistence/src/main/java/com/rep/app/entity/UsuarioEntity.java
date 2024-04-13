package com.rep.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_USUARIO")
public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

}
