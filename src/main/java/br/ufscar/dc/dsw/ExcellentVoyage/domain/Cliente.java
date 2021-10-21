package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente extends Usuario {

    @NotBlank
    @Size(min = 14, max = 14, message = "Tem que ter 14 números")
    @Column(name = "cpf", nullable = false, length = 14)
    private String cpf;

    @NotBlank
    @Size(min = 11, max = 11, message = "Tem que ter 11 números, ddd + celular")
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @NotBlank
    @Size(min = 10, max = 10)
    @Column(name = "data_nascimento", nullable = false)
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