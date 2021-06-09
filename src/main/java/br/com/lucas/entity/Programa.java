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
@Table(name = "programas")
public class Programa implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "idPrograma")
	@JsonProperty("idPrograma")
	private Long idPrograma;
	
	@Column(name = "programa")
	@JsonProperty("programa")
	private String programa;
	
	public Programa() {
		
	}

	public Programa(Long id, Long idPrograma, String programa) {
		super();
		this.id = id;
		this.idPrograma = idPrograma;
		this.programa = programa;
	}

	@Override
	public String toString() {
		return "Programa [id=" + id + ", idPrograma=" + idPrograma + ", programa=" + programa + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
