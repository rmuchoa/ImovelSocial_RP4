package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Locatario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8429915141656617275L;
	
	private Long id;
	private Usuario usuario;
	private ImovelCompleto imovelAlugado;
	
	public Locatario() {
		
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="idUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToOne
	@JoinColumn(name="idImovel")
	public ImovelCompleto getImovelAlugado() {
		return imovelAlugado;
	}

	public void setImovelAlugado(ImovelCompleto imovelAlugado) {
		this.imovelAlugado = imovelAlugado;
	}
	
}
