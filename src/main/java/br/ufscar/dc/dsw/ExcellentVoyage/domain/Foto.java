package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto {
    @ManyToOne
    @JoinColumn(name = "id")
    private Long idPacote;

    @Column(nullable = false)
    private String url;

    public Long getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Long idPacote) {
        this.idPacote = idPacote;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
