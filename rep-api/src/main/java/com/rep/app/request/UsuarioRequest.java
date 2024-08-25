package com.rep.app.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotNull(message = "userLogin não pode ser nulo")
    @Size(min = 5, max = 11, message = "userLogin deve ter no minimo 5 caracteres e no maximo 11 caracteres")
    private String login;

    @NotNull(message = "userPassword não pode ser nulo")
    @Size(min = 5, message = "userPassword deve ter no minimo 5 caracteres")
    private String senha;

    @NotNull(message = "userEmail não pode ser nulo")
    private String email;

}
