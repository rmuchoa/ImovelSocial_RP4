package br.com.unipampa.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ImovelCompleto extends Imovel {

	//private Long id;
	private Double valorAluguel;
	private Locatario locatario;
	
	public ImovelCompleto() {
		
	}

	public Double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	@ManyToOne
	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}
	
}
