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
@Table(name = "canal")
public class Canal implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idCanal")
	@JsonProperty("idCanal")
	private Long idCanal;
	
	@Column(name = "canal")
	@JsonProperty("canal")
	private String canal;
	
	
	public Canal() {
		// TODO Auto-generated constructor stub
	}


	public Canal(Long idCanal, String canal) {
		super();
		this.idCanal = idCanal;
		this.canal = canal;
	}


	@Override
	public String toString() {
		return "Canal [idCanal=" + idCanal + ", canal=" + canal + "]";
	}


	public Long getIdCanal() {
		return idCanal;
	}


	public void setIdCanal(Long idCanal) {
		this.idCanal = idCanal;
	}


	public String getCanal() {
		return canal;
	}


	public void setCanal(String canal) {
		this.canal = canal;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
