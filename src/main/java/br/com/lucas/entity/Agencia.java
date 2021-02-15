package br.com.lucas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name= "agencia")
public class Agencia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	@JsonProperty("id")
	private Long id;
	
	@Column(name ="idAgencia")
	@JsonProperty("idAgencia")
	private Long idAgencia;
	
	@Column(name = "agencia")
	@JsonProperty("agencia")
	private String agencia;
	
	
	public Agencia() {
		// TODO Auto-generated constructor stub
	}


	public Agencia(Long id, Long idAgencia, String agencia) {
		super();
		this.id = id;
		this.idAgencia = idAgencia;
		this.agencia = agencia;
	}


	@Override
	public String toString() {
		return "Agencia [id=" + id + ", idAgencia=" + idAgencia + ", agencia=" + agencia + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdAgencia() {
		return idAgencia;
	}


	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}


	public String getAgencia() {
		return agencia;
	}


	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
