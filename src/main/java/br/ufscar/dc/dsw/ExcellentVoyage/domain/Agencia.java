package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "agencia")
public class Agencia extends Usuario {

    @NotBlank
    @Size(min = 18, max = 18, message = "Tem que ter 18 números")
    @Column(name = "cnpj", nullable = false, length = 18)
    private String cnpj;

    @NotBlank
    @Size(min = 18, max = 120, message = "Tem que ter no minimo 18 caracteres")
    @Column(name = "descricao", nullable = false, length = 120)
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