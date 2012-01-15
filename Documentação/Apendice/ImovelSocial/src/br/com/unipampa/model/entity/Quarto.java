package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import br.com.unipampa.model.entity.enumeration.TipoQuarto;

@Entity
public class Quarto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8827358206689562726L;
	
	private Long id;
	private TipoQuarto tipoQuarto;
	private List<Vaga> vagas;
	private Boolean mobiliado;
	private Boolean suite;
	private Imovel imovel;
	
	public Quarto() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="quarto_generator")
	@SequenceGenerator(name="quarto_generator", sequenceName="quarto_sequence")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	@OneToMany(mappedBy="quarto", cascade={CascadeType.ALL})
	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public Boolean isMobiliado() {
		return mobiliado;
	}

	public void setMobiliado(Boolean mobiliado) {
		this.mobiliado = mobiliado;
	}

	public Boolean isSuite() {
		return suite;
	}

	public void setSuite(Boolean suite) {
		this.suite = suite;
	}

	@ManyToOne
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
}
