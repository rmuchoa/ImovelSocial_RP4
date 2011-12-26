package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Inquilino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3171508254550333430L;
	
	private Long id;
	private Usuario usuario;
	private Vaga vaga;
	
	public Inquilino() {
		
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

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idVaga")
	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
}
