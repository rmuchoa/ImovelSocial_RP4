package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Locatario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8429915141656617275L;
	
	private Long id;
	private Usuario usuario;
	private ArrayList<ImovelCompleto> imoveisAlugados;
	
	public Locatario() {
		
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
	public ArrayList<ImovelCompleto> getImoveisAlugados() {
		return imoveisAlugados;
	}

	public void setImoveisAlugados(ArrayList<ImovelCompleto> imoveisAlugados) {
		this.imoveisAlugados = imoveisAlugados;
	}
	
}
