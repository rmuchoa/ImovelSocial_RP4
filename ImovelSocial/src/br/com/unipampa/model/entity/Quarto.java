package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import br.com.unipampa.model.entity.enumeration.TipoQuarto;

@Entity
public class Quarto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8827358206689562726L;
	
	private Long id;
	private TipoQuarto tipoQuarto;
	private Boolean suite;
	private Boolean mobiliado;
	
	public Quarto() {
		
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Boolean isSuite() {
		return suite;
	}

	public void setSuite(Boolean suite) {
		this.suite = suite;
	}

	public Boolean isMobiliado() {
		return mobiliado;
	}

	public void setMobiliado(Boolean mobiliado) {
		this.mobiliado = mobiliado;
	}
	
}
