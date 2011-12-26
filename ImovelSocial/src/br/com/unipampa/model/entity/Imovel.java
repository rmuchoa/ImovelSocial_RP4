package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Imovel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1522429232256368406L;
	
	private Long id;
	private String endereco;
	private Integer numComodos;
	private Integer numBanheiros;
	private Boolean comVaranda;
	private Boolean comQuintal;
	private Boolean comInternet;
	private Boolean mobiliado;
	private ArrayList<Quarto> quartos; 
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
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	@OneToMany(cascade=CascadeType.ALL)
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@OneToMany(cascade=CascadeType.ALL)
	public ArrayList<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(ArrayList<Quarto> quartos) {
		this.quartos = quartos;
	}
	
}
