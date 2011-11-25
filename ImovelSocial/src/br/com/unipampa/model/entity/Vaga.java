package br.com.unipampa.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vaga {

	private Long id;
	private Double mensalidade;
	private Boolean incluiDespesasAdicionais;
	private Double valorDespesasAdicionais;
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

	@ManyToOne
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
}
