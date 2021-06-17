package br.com.lucas.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "produtos")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "idProduto")
	@JsonProperty("idProduto")
	private Long idProduto;
	
	@Column(name = "produto")
	@JsonProperty("produto")
	private String produto;
	
//	@OneToMany(mappedBy = "produtos", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER )
//	@JsonManagedReference
//	private List<Acao> acoes;//RELACIONAMENTO ONE TO MANY
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Long id, Long idProduto, String produto) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", idProduto=" + idProduto + ", produto=" + produto + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
