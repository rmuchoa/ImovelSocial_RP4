package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
	private List<Quarto> quartos; 
	private Proprietario proprietario;
	
	public Imovel() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="imovel_generator")
	@SequenceGenerator(name="imovel_generator", sequenceName="imovel_sequence")
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

	@OneToMany(mappedBy="imovel", cascade={CascadeType.ALL})
	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	@OneToOne(mappedBy="imovel", cascade={CascadeType.ALL})
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
}
