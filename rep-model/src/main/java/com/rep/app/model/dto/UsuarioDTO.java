package com.rep.app.model.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String userLogin;
    private String userPassword;
    private String userEmail;
}
