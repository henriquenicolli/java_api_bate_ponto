package com.rep.app.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class UsuarioDTO extends User {

    private String idUsuario;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private String idEmpregado;

    public UsuarioDTO(String username, String password, String idEmpregado , Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.idEmpregado = idEmpregado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(String idEmpregado) {
        this.idEmpregado = idEmpregado;
    }
}
