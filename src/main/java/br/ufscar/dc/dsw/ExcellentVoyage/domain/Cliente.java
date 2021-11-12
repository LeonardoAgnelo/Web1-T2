package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.ufscar.dc.dsw.ExcellentVoyage.validation.UniqueCPF;

@Entity
@Table(name = "Cliente")
@PrimaryKeyJoinColumn(name="idUsuario")
public class Cliente extends Usuario {

    @UniqueCPF(message = "{unique.cliente.cpf}")
    @NotBlank(message = "{NotBlank.cliente.cpf}")
    @Size(min = 14, max = 14, message = "{Size.cliente.cpf}")
    @Column(name = "cpf", nullable = false, unique = true, length = 14)
    private String cpf;

    @NotBlank(message = "{NotBlank.cliente.telefone}")
    @Size(min = 11, max = 11, message = "{Size.cliente.telefone}")
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @NotBlank(message = "{NotBlank.cliente.sexo}")
    @Column(name = "sexo", nullable = false)
    private String sexo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past()
    @NotNull(message = "{NotBlank.cliente.dataNacminto}")
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