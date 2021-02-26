package br.com.lucas.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime entrada; // = LocalTime.parse("00:00:00")

	@Column(name = "saida")
	@JsonProperty("saida")
//	@JsonFormat(pattern = "HH:mm:ss")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime saida; // = LocalTime.parse("00:00:00") private LocalTime saida;

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

	@Column(name = "tvAberta")
	@JsonProperty("tvAberta")
	private Boolean tvAberta;

	public Acao() {

	}

	public Acao(Long id, String programa, LocalDate data, String cliente, Long idCliente, String produto,
			String tipoAcao, String descricao, LocalDateTime entrada, LocalDateTime saida, String agencia, String url,
			Long idAgencia, Boolean tvAberta) {
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
		this.tvAberta = tvAberta;
	}

	@PrePersist
	public void calculoDiferenca() {

		LocalDateTime start = LocalDateTime.of(entrada.getYear(), entrada.getMonth(), entrada.getDayOfMonth(),
				entrada.getHour(), entrada.getMinute(), entrada.getSecond());

		LocalDateTime stop = LocalDateTime.of(saida.getYear(), saida.getMonth(), saida.getDayOfMonth(), saida.getHour(),
				saida.getMinute(), saida.getSecond());

		long diferencaSegundos = start.until(stop, ChronoUnit.SECONDS);
//		long diferencaDias = start.until(stop, ChronoUnit.DAYS);

		long timeinsec = 0;
		long timeinminaux = 0;
		long timeinhr = 0;
		long timeinmin = 0;

		while (diferencaSegundos % 60 != 0) {
			diferencaSegundos = diferencaSegundos - 1;
			timeinsec = timeinsec + 1;
		}
		timeinminaux = (diferencaSegundos / 60);
		diferencaSegundos = 0;

		while (timeinminaux % 60 != 0) {

			timeinminaux = timeinminaux - 1;
			timeinmin = timeinmin + 1;

		}
		timeinhr = (timeinminaux / 60);
		diferencaSegundos = 0;
		

//		if (diferencaDias == 0) {

			System.out.println("O tempo é : " + timeinhr + ":" + timeinmin + ":" + timeinsec);

			int timehr = (int) timeinhr;
			int timemin = (int) timeinmin;
			int timesec = (int) timeinsec;

			LocalTime total = LocalTime.of(timehr, timemin, timesec);
			duracao = total;

//		}
//		else if (diferencaDias > 0) {
//			
//			System.out.println("seu dia e maior que 0");
			
//			int timehr2 = (int) 24 - start.getHour() + stop.getHour();
//			int timehr = timehr2;
//			int timemin = (int) timeinmin;
//			int timesec = (int) timeinsec;
//			
//			LocalTime total = LocalTime.of(timehr, timemin, timesec);
//			duracao = total;
			
			

//		}

	}

	@Override
	public String toString() {
		return "Acao [id=" + id + ", programa=" + programa + ", data=" + data + ", cliente=" + cliente + ", idCliente="
				+ idCliente + ", produto=" + produto + ", tipoAcao=" + tipoAcao + ", descricao=" + descricao
				+ ", entrada=" + entrada + ", saida=" + saida + ", agencia=" + agencia + ", url=" + url + ", idAgencia="
				+ idAgencia + ", duracao=" + duracao + ", tvAberta=" + tvAberta + "]";
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

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
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

	public Boolean getTvAberta() {
		return tvAberta;
	}

	public void setTvAberta(Boolean tvAberta) {
		this.tvAberta = tvAberta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
