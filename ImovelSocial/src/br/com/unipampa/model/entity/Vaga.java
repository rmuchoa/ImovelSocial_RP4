package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private ArrayList<InteresseVaga> interesses;
	private Inquilino inquilino;
	
	public Vaga() {
		
	}

	@Id
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

	@OneToMany
	public ArrayList<InteresseVaga> getInteresses() {
		return interesses;
	}

	public void setInteresses(ArrayList<InteresseVaga> interesses) {
		this.interesses = interesses;
	}

	@OneToOne
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
}
