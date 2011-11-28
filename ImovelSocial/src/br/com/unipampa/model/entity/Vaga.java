package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vaga implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 586829243658648771L;
	
	private Long id;
	private Double mensalidade;
	private Boolean incluiDespesasAdicionais;
	private Double valorDespesasAdicionais;
	private ArrayList<InteresseVaga> interesses;
	private Inquilino inquilino;
	private Locador locador;
	
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

	public Boolean isIncluiDespesasAdicionais() {
		return incluiDespesasAdicionais;
	}

	public void setIncluiDespesasAdicionais(Boolean incluiDespesasAdicionais) {
		this.incluiDespesasAdicionais = incluiDespesasAdicionais;
	}

	public Double getValorDespesasAdicionais() {
		return valorDespesasAdicionais;
	}

	public void setValorDespesasAdicionais(Double valorDespesasAdicionais) {
		this.valorDespesasAdicionais = valorDespesasAdicionais;
	}

	@OneToMany
	public ArrayList<InteresseVaga> getInteresses() {
		return interesses;
	}

	public void setInteresses(ArrayList<InteresseVaga> interesses) {
		this.interesses = interesses;
	}

	@ManyToOne
	@JoinColumn(name = "idInquilino")
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	@ManyToOne
	@JoinColumn(name = "idLocador")
	public Locador getLocador() {
		return locador;
	}

	public void setLocador(Locador locador) {
		this.locador = locador;
	}
	
}
