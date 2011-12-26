package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proprietario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3778918442333600433L;
	
	private Long id;
	private Usuario usuario;
	private Imovel imovel;
	
	public Proprietario() {
		
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idImovel")
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
}
