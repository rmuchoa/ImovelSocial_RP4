package br.com.unipampa.model.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Locatario {

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
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany(mappedBy = "idLocatario")
	public ArrayList<ImovelCompleto> getImoveisAlugados() {
		return imoveisAlugados;
	}

	public void setImoveisAlugados(ArrayList<ImovelCompleto> imoveisAlugados) {
		this.imoveisAlugados = imoveisAlugados;
	}
	
}
