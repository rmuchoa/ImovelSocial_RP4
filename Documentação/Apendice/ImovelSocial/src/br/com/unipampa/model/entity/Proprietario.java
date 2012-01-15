package br.com.unipampa.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proprietario_generator")
	@SequenceGenerator(name="proprietario_generator", sequenceName="proprietario_sequence")
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

	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
}
