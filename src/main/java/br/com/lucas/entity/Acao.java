package br.com.lucas.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;


@Entity
@Table(name ="acao")
public class Acao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "programa", length=100)
	@JsonProperty("programa")
	@NotNull
	private String programa;
	
	@Column(name = "data")
	@JsonProperty("data")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;
	
	@Column(name = "cliente", length=250)
	@JsonProperty("cliente")
	private String cliente;
	
	@Column(name = "idCliente")
	@JsonProperty("idCliente")
	private Long idCliente;
	
	@Column(name = "produto", length = 100)
	@JsonProperty("produto")
	private String produto;
	
	@Column(name = "tipoAcao")
	@JsonProperty("tipoAcao")
	private String tipoAcao;
	
	@Column(name = "descricao", length = 250)
	@JsonProperty("descricao")
	private String descricao;
	
	@Column(name = "entrada")
	@JsonProperty("entrada")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime entrada;
	
	@Column(name = "saida")
	@JsonProperty("saida")
	@JsonFormat(pattern = "HH:mm:ss")	
	private LocalTime saida;
	
	@Column(name = "agencia")
	@JsonProperty("agencia")
	private String agencia;
	
	@Column(name = "numeroVideo")
	@JsonProperty("numeroVideo")
	private Long numeroVideo;
	
	@Column(name = "idAgencia")
	@JsonProperty("idAgencia")
	private Long idAgencia;
	
	@Column(name = "idSistema")
	@JsonProperty("idSistema")
	private Long idSistema;
	
	public Acao() {
		
	}

	public Acao(Long id, String programa, LocalDate data, String cliente, Long idCliente, String produto,
			String tipoAcao, String descricao, LocalTime entrada, LocalTime saida, String agencia, Long numeroVideo,
			Long idAgencia, Long idSistema) {
		super();
		this.id = id;
		this.programa = programa;
		this.data = data;
		this.cliente = cliente;
		this.idCliente = idCliente;
		this.produto = produto;
		this.tipoAcao = tipoAcao;
		this.descricao = descricao;
		this.entrada = entrada;
		this.saida = saida;
		this.agencia = agencia;
		this.numeroVideo = numeroVideo;
		this.idAgencia = idAgencia;
		this.idSistema = idSistema;
	}

	@Override
	public String toString() {
		return "Acao [id=" + id + ", programa=" + programa + ", data=" + data + ", cliente=" + cliente + ", idCliente="
				+ idCliente + ", produto=" + produto + ", tipoAcao=" + tipoAcao + ", descricao=" + descricao
				+ ", entrada=" + entrada + ", saida=" + saida + ", agencia=" + agencia + ", numeroVideo=" + numeroVideo
				+ ", idAgencia=" + idAgencia + ", idSistema=" + idSistema + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalTime entrada) {
		this.entrada = entrada;
	}

	public LocalTime getSaida() {
		return saida;
	}

	public void setSaida(LocalTime saida) {
		this.saida = saida;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Long getNumeroVideo() {
		return numeroVideo;
	}

	public void setNumeroVideo(Long numeroVideo) {
		this.numeroVideo = numeroVideo;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

	public Long getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(Long idSistema) {
		this.idSistema = idSistema;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	

	

}
