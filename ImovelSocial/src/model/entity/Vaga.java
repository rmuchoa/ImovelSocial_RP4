package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vaga database table.
 * 
 */
@Entity
@Table(name="vaga")
@NamedQueries({
    @NamedQuery(name = "Vaga.findAll", 					query = "SELECT v FROM Vaga v"),
    @NamedQuery(name = "Vaga.findById", 				query = "SELECT v FROM Vaga v WHERE v.id = :id"),
    @NamedQuery(name = "Vaga.findByTipoVaga", 			query = "SELECT v FROM Vaga v WHERE v.tipoVaga = :tipoVaga"),
    @NamedQuery(name = "Vaga.findByMensalidade", 		query = "SELECT v FROM Vaga v WHERE v.mensalidade = :mensalidade"),
    @NamedQuery(name = "Vaga.findByOutrasInformacoes", 	query = "SELECT v FROM Vaga v WHERE v.outrasInformacoes = :outrasInformacoes"),
    @NamedQuery(name = "Vaga.findByImovel.Endereco",	query = "SELECT v FROM Vaga v WHERE v.imovel.endereco = :endereco")})
public class Vaga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="tipo_vaga", length=255)
	private String tipoVaga;

	@Column(name="mensalidade")
	private double mensalidade;

	@Column(name="outras_informacoes", length=255)
	private String outrasInformacoes;

	//bi-directional many-to-one association to Interesse
	@OneToMany(mappedBy="vaga")
	private List<Interesse> interesses;

	//bi-directional many-to-one association to Quarto
    @ManyToOne
	@JoinColumn(name="quarto")
	private Quarto quarto;
    
  //bi-directional many-to-one association to Imovel
    @ManyToOne
    @JoinColumn(name="imovel")
    private Imovel imovel;

    public Vaga() {
    	
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMensalidade() {
		return this.mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public String getOutrasInformacoes() {
		return this.outrasInformacoes;
	}

	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public String getTipoVaga() {
		return this.tipoVaga;
	}

	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

	public List<Interesse> getInteresses() {
		return this.interesses;
	}

	public void setInteresses(List<Interesse> interesses) {
		this.interesses = interesses;
	}
	
	public Quarto getQuarto() {
		return this.quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

    public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
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
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vaga[ id=" + id + " ]";
    }
	
}