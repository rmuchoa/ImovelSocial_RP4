package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Locador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4939472357782898779L;
	
	private Long id;
	private Usuario usuario;
	private Vaga vaga;
	
	public Locador() {
		
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToOne
	@JoinColumn(name = "idVaga")
	public Vaga getVagas() {
		return vaga;
	}
	
	public void setVagas(Vaga vaga) {
		this.vaga = vaga;
	}

}
