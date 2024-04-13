package com.rep.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_EMPR_ENDC")
public class EnderecoEntity {

    @Id
    @Column(name = "id_endereco")
    private int idEndereco;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cep")
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "pais")
    private String pais;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private EmpresaEntity empresa;

}
