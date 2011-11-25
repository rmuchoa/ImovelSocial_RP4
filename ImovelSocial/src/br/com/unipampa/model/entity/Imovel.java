package br.com.unipampa.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.unipampa.model.entity.enumeration.TipoLogradouro;

@Entity
public class Imovel {
	
	private Long id;
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private Integer numero;
	private Integer complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private Integer numComodos;
	private Integer numBanheiros;
	private Boolean comVaranda;
	private Boolean comQuintal;
	private Boolean comInternet;
	private Boolean mobiliado;
	private Proprietario proprietario;
	
	public Imovel() {
		
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getComplemento() {
		return complemento;
	}

	public void setComplemento(Integer complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getNumComodos() {
		return numComodos;
	}

	public void setNumComodos(Integer numComodos) {
		this.numComodos = numComodos;
	}

	public Integer getNumBanheiros() {
		return numBanheiros;
	}

	public void setNumBanheiros(Integer numBanheiros) {
		this.numBanheiros = numBanheiros;
	}

	public Boolean isComVaranda() {
		return comVaranda;
	}

	public void setComVaranda(Boolean comVaranda) {
		this.comVaranda = comVaranda;
	}

	public Boolean isComQuintal() {
		return comQuintal;
	}

	public void setComQuintal(Boolean comQuintal) {
		this.comQuintal = comQuintal;
	}

	public Boolean isComInternet() {
		return comInternet;
	}

	public void setComInternet(Boolean comInternet) {
		this.comInternet = comInternet;
	}

	public Boolean isMobiliado() {
		return mobiliado;
	}

	public void setMobiliado(Boolean mobiliado) {
		this.mobiliado = mobiliado;
	}

	@ManyToOne
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
}
