package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Agencia")
public class Agencia extends Usuario {

    @NotBlank
    @Size(min = 18, max = 18, message = "Tem que ter 18 números")
    @Column(nullable = false, length = 60)
    private String cnpj;

    @NotBlank
    @Size(min = 18, max = 120, message = "Tem que ter no minimo 18 caracteres")
    @Column(nullable = false, length = 120)
    private String descricao;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}