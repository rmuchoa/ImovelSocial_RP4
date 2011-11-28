package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Inquilino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3171508254550333430L;
	
	private Long id;
	private Usuario usuario;
	private ArrayList<Vaga> vaga;
	
	public Inquilino() {
		
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "idUsuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany
	public ArrayList<Vaga> getVaga() {
		return vaga;
	}

	public void setVaga(ArrayList<Vaga> vaga) {
		this.vaga = vaga;
	}
	
}
