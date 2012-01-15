package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Vaga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 586829243658648771L;
	
	private Long id;
	private Double mensalidade;
	private String servicosIncluidos;
	private String servicosNaoIncluidos;
	private Double despesasAdicionais;
	private List<Interesse> interesses;
	private Inquilino inquilino;
	private Quarto quarto;
	
	public Vaga() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="vaga_generator")
	@SequenceGenerator(name="vaga_generator", sequenceName="vaga_sequence")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public String getServicosIncluidos() {
		return servicosIncluidos;
	}

	public void setServicosIncluidos(String servicosIncluidos) {
		this.servicosIncluidos = servicosIncluidos;
	}

	public String getServicosNaoIncluidos() {
		return servicosNaoIncluidos;
	}

	public void setServicosNaoIncluidos(String servicosNaoIncluidos) {
		this.servicosNaoIncluidos = servicosNaoIncluidos;
	}

	public Double getDespesasAdicionais() {
		return despesasAdicionais;
	}

	public void setDespesasAdicionais(Double despesasAdicionais) {
		this.despesasAdicionais = despesasAdicionais;
	}

	@OneToMany(mappedBy="vaga", cascade={CascadeType.ALL})
	public List<Interesse> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<Interesse> interesses) {
		this.interesses = interesses;
	}

	@OneToOne(mappedBy="vaga", cascade={CascadeType.ALL})
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	@ManyToOne
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
}
