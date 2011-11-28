package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Locador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4939472357782898779L;
	
	private Long id;
	private Usuario usuario;
	private ArrayList<Vaga> vagas;
	
	public Locador() {
		
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
	public ArrayList<Vaga> getVagas() {
		return vagas;
	}
	
	public void setVagas(ArrayList<Vaga> vagas) {
		this.vagas = vagas;
	}

}
