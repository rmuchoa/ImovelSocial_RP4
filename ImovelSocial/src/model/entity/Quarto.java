package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the quarto database table.
 * 
 */
@Entity
@Table(name="quarto")
@NamedQueries({
    @NamedQuery(name = "Quarto.findAll", 			query = "SELECT q FROM Quarto q"),
    @NamedQuery(name = "Quarto.findById", 			query = "SELECT q FROM Quarto q WHERE q.id = :id"),
    @NamedQuery(name = "Quarto.findByMobiliado", 	query = "SELECT q FROM Quarto q WHERE q.mobiliado = :mobiliado"),
    @NamedQuery(name = "Quarto.findBySuite", 		query = "SELECT q FROM Quarto q WHERE q.suite = :suite"),
    @NamedQuery(name = "Quarto.findByComSacada", 	query = "SELECT q FROM Quarto q WHERE q.comSacada = :comSacada"),
    @NamedQuery(name = "Quarto.findByTipoQuarto", 	query = "SELECT q FROM Quarto q WHERE q.tipoQuarto = :tipoQuarto")})
public class Quarto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="mobiliado")
	private Boolean mobiliado;

	@Column(name="suite")
	private Boolean suite;

	@Column(name="com_sacada")
	private Boolean comSacada;

	@Column(name="tipo_quarto", length=255)
	private String tipoQuarto;

	//bi-directional many-to-one association to Imovel
    @ManyToOne
	@JoinColumn(name="imovel")
	private Imovel imovel;

	//bi-directional many-to-one association to Vaga
	@OneToMany(mappedBy="quarto")
	private List<Vaga> vagas;

    public Quarto() {
    	
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getComSacada() {
		return this.comSacada;
	}

	public void setComSacada(Boolean comSacada) {
		this.comSacada = comSacada;
	}

	public Boolean getMobiliado() {
		return this.mobiliado;
	}

	public void setMobiliado(Boolean mobiliado) {
		this.mobiliado = mobiliado;
	}

	public Boolean getSuite() {
		return this.suite;
	}

	public void setSuite(Boolean suite) {
		this.suite = suite;
	}

	public String getTipoQuarto() {
		return this.tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public Imovel getImovel() {
		return this.imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	
	public List<Vaga> getVagas() {
		return this.vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quarto)) {
            return false;
        }
        Quarto other = (Quarto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quarto[ id=" + id + " ]";
    }
	
}