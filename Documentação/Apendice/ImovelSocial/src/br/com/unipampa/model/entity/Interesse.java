package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Interesse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5842070028955124155L;
	
	private Long id;
	private Usuario usuario;
	private Vaga vaga;
	
	public Interesse() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="interesse_generator")
	@SequenceGenerator(name="interesse_generator", sequenceName="interesse_sequence")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}
