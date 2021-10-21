package br.ufscar.dc.dsw.ExcellentVoyage.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "PacoteTuristico")
public class PacoteTuristico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cnpjAgencia")
    private Agencia agencia;

    @Column(nullable = false, length = 60)
    private String destinoCidade;

    @Column(nullable = false, length = 60)
    private String destinoEstado;

    @Column(nullable = false, length = 60)
    private String destinoPais;

    @Column(nullable = false)
    private Date dataPartida;

    @Column(nullable = false)
    private Integer duracaoDias;

    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.0")
    private BigDecimal valor;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer qtdFoto;

	@OneToMany(mappedBy = "pacoteTuristico")
	private List<Foto> fotos;

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
