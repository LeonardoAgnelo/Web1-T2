package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente extends Usuario {

    @NotBlank(message = "{NotBlank.cliente.cpf}")
    @Size(min = 14, max = 14, message = "{Size.cliente.cpf}")
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @NotBlank(message = "{NotBlank.cliente.telefone}")
    @Size(min = 11, max = 11, message = "{Size.cliente.telefone}")
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @NotBlank(message = "{NotBlank.cliente.sexo}")
    @Size(min = 11, max = 11)
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @NotBlank(message = "{NotBlank.cliente.dataNacminto}")
    @Size(min = 10, max = 10)
    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}