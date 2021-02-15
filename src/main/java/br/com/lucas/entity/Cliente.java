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
@Table(name = "cliente")
public class Cliente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "idCliente")
	@JsonProperty("idCliente")
	private Long idCliente;
	
	@Column(name = "cliente")
	@JsonProperty("cliente")
	private String cliente;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, Long idCliente, String cliente) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", idCliente=" + idCliente + ", cliente=" + cliente + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	

}
