package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "pacote_turistico")
public class PacoteTuristico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cnpj_agencia")
    private Agencia agencia;

    @Column(name = "destino_cidade", nullable = false, length = 60)
    private String destinoCidade;

    @Column(name = "destino_estado", nullable = false, length = 60)
    private String destinoEstado;

    @Column(name = "destino_pais", nullable = false, length = 60)
    private String destinoPais;

    @Column(name = "data_partida", nullable = false)
    private Date dataPartida;

    @Column(name = "duracao_dias", nullable = false)
    private Integer duracaoDias;

    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.0")
    private BigDecimal valor;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "qtd_foto", nullable = false)
    private Integer qtdFoto;

	public void setId (Long id) {
		this.id = id;
	}

	public Long getId () {
		return this.id;
	}

	public void setAgencia (Agencia agencia) {
		this.agencia = agencia;
	}

	public Agencia getAgencia () {
		return this.agencia;
	}

	public void setDestinoCidade (String destinoCidade) {
		this.destinoCidade = destinoCidade;
	}

	public String getDestinoCidade () {
		return this.destinoCidade;
	}

	public void setDestinoEstado (String destinoEstado) {
		this.destinoEstado = destinoEstado;
	}

	public String getDestinoEstado () {
		return this.destinoEstado;
	}

	public void setDestinoPais (String destinoPais) {
		this.destinoPais = destinoPais;
	}

	public String getDestinoPais () {
		return this.destinoPais;
	}

	public void setDataPartida (Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public Date getDataPartida () {
		return this.dataPartida;
	}

	public void setDuracaoDias (Integer duracaoDias) {
		this.duracaoDias = duracaoDias;
	}

	public Integer getDuracaoDias () {
		return this.duracaoDias;
	}

	public void setValor (BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValor () {
		return this.valor;
	}

	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao () {
		return this.descricao;
	}

	public void setQtdFoto (Integer qtdFoto) {
		this.qtdFoto = qtdFoto;
	}

	public Integer getQtdFoto () {
		return this.qtdFoto;
	}
}
