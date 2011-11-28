package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ImovelCompleto extends Imovel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5219568873013667350L;
	
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
	@JoinColumn(name = "idLocatario")
	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}
	
}
