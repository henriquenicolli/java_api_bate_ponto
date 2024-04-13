package com.rep.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_INFO_PTRP")
public class InfoPtrpEntity {

    @Id
    @Column(name = "id_info_ptrp")
    private int idInfoPtrp;

    @Column(name = "nome_ptrp")
    private String nomePtrp;

    @Column(name = "versao_ptrp")
    private String versaoPtrp;

    @Column(name = "tipo_idef_desenvolvedor")
    private String tipoIdentificacaoDesenvolvedor;

    @Column(name = "cpf_cnpj_desenvolvedor")
    private String cpfCnpjDesenvolvedor;

    @Column(name = "razao_social_desenvolvedor")
    private String razaoSocialDesenvolvedor;

    @Column(name = "email_desenvolvedor")
    private String emailDesenvolvedor;

    @Column(name = "assinatura")
    private String assinatura;

}
