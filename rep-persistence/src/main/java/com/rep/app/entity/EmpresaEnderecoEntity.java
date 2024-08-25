package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_EMPR_ENDC")
public class EmpresaEnderecoEntity {

    @Id
    @Column(name = "id_endereco")
    private String idEndereco;

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

    @Column(name = "excluido")
    private boolean excluido;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private EmpresaEntity empresa;

}