package br.com.lucas.entity;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

//import ch.qos.logback.core.util.Duration;

@Entity
@Table(name = "acao")
public class Acao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;

	@Column(name = "programa", length = 100)
	@JsonProperty("programa")
	@NotNull
	private String programa;

	@Column(name = "data")
	@JsonProperty("data")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;

	@Column(name = "cliente", length = 250)
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
	private LocalTime entrada; // = LocalTime.parse("00:00:00")

	@Column(name = "saida")
	@JsonProperty("saida")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime saida; // = LocalTime.parse("00:00:00")

	@Column(name = "agencia")
	@JsonProperty("agencia")
	private String agencia;

//	@Column(name = "numeroVideo")
//	@JsonProperty("numeroVideo")
//	private Long numeroVideo;

	@Column(name = "url")
	@JsonProperty("url")
	private String url;

	@Column(name = "idAgencia")
	@JsonProperty("idAgencia")
	private Long idAgencia;
	
	@Column(name = "duracao")
	@JsonProperty("duracao")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime duracao;

//	@Column(name = "idSistema")
//	@JsonProperty("idSistema")
//	private Long idSistema;

	public Acao() {

	}

	
	
	public Acao(Long id, String programa, LocalDate data, String cliente, Long idCliente, String produto, String tipoAcao,
		String descricao, LocalTime entrada, LocalTime saida, String agencia, String url, Long idAgencia) {
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
	this.url = url;
	this.idAgencia = idAgencia;
}


//	@PrePersist
	public Acao calculoDiferenca() {
		
		LocalTime inicio = LocalTime.of(entrada.getHour(), entrada.getMinute(), entrada.getSecond());
		LocalTime fim = LocalTime.of(saida.getHour(), saida.getMinute(), saida.getSecond());
		
		Duration duracao = Duration.between(inicio, fim);
		long diff = duracao.toHours();
		System.out.println(diff);
		
		
		return this;
		
	}

	
	@Override
	public String toString() {
		return "Acao [id=" + id + ", programa=" + programa + ", data=" + data + ", cliente=" + cliente + ", idCliente="
				+ idCliente + ", produto=" + produto + ", tipoAcao=" + tipoAcao + ", descricao=" + descricao
				+ ", entrada=" + entrada + ", saida=" + saida + ", agencia=" + agencia + ", url=" + url + ", idAgencia="
				+ idAgencia + ", duracao=" + duracao + "]";
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



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Long getIdAgencia() {
		return idAgencia;
	}



	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}



	public LocalTime getDuracao() {
		return duracao;
	}



	public void setDuracao(LocalTime duracao) {
		this.duracao = duracao;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



//	public static void main(String[] args) {
//		try {
//			
//			Acao acao = new Acao(56,"bbb21","18-02-2021","pewtrobras",3,"petroleo","acao","acao ana maria","09:12:34","09:32:01","wmccan","http://localhost:4200",9).calculoDiferenca();
//			
//		}catch(Exception ex) {
//			
//		}
//	}

}
