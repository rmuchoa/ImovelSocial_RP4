package br.com.unipampa.model.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Inquilino {

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
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(mappedBy = "idInquilino")
	public ArrayList<Vaga> getVaga() {
		return vaga;
	}

	public void setVaga(ArrayList<Vaga> vaga) {
		this.vaga = vaga;
	}
	
}
