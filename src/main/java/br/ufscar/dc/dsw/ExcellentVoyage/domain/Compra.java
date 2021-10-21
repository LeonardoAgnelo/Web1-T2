package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_pacote")
    private PacoteTuristico pacoteTuristico;

    @Column(name = "data_reuniao", nullable = false)
    private Date dataReuniao;

    @Column(name = "link_reuniao", nullable = false)
    private String linkReuniao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PacoteTuristico getPacoteTuristico() {
        return pacoteTuristico;
    }

    public void setPacoteTuristico(PacoteTuristico pacoteTuristico) {
        this.pacoteTuristico = pacoteTuristico;
    }

    public Date getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(Date dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public String getLinkReuniao() {
        return linkReuniao;
    }

    public void setLinkReuniao(String linkReuniao) {
        this.linkReuniao = linkReuniao;
    }
}