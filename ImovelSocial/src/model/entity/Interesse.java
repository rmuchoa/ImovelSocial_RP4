package model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the interesse database table.
 * 
 */
@Entity
@Table(name="interesse")
public class Interesse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Vaga
    @ManyToOne
	@JoinColumn(name="vaga")
	private Vaga vaga;

    public Interesse() {
    	
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Vaga getVaga() {
		return this.vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
}