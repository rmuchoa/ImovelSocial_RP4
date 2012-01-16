package model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imovel database table.
 * 
 */
@Entity
@Table(name="imovel")
@NamedQueries({
    @NamedQuery(name = "Imovel.findAll", 					query = "SELECT i FROM Imovel i"),
    @NamedQuery(name = "Imovel.findById", 					query = "SELECT i FROM Imovel i WHERE i.id = :id"),
    @NamedQuery(name = "Imovel.findByTipoImovel", 			query = "SELECT i FROM Imovel i WHERE i.tipoImovel = :tipoImovel"),
    @NamedQuery(name = "Imovel.findByCidade", 				query = "SELECT i FROM Imovel i WHERE i.cidade = :cidade"),
    @NamedQuery(name = "Imovel.findByLogradouro", 			query = "SELECT i FROM Imovel i WHERE i.logradouro = :logradouro"),
    @NamedQuery(name = "Imovel.findByEndereco", 			query = "SELECT i FROM Imovel i WHERE i.endereco = :endereco"),
    @NamedQuery(name = "Imovel.findByNumero", 				query = "SELECT i FROM Imovel i WHERE i.numero = :numero"),
    @NamedQuery(name = "Imovel.findByBairro", 				query = "SELECT i FROM Imovel i WHERE i.bairro = :bairro"),
    @NamedQuery(name = "Imovel.findByNumComodos", 			query = "SELECT i FROM Imovel i WHERE i.numComodos = :numComodos"),
    @NamedQuery(name = "Imovel.findByNumBanheiros", 		query = "SELECT i FROM Imovel i WHERE i.numBanheiros = :numBanheiros"),
    @NamedQuery(name = "Imovel.findByMobiliado", 			query = "SELECT i FROM Imovel i WHERE i.mobiliado = :mobiliado"),
    @NamedQuery(name = "Imovel.findByComVaranda", 			query = "SELECT i FROM Imovel i WHERE i.comVaranda = :comVaranda"),
    @NamedQuery(name = "Imovel.findByComQuintal", 			query = "SELECT i FROM Imovel i WHERE i.comQuintal = :comQuintal"),
    @NamedQuery(name = "Imovel.findByComInternet", 			query = "SELECT i FROM Imovel i WHERE i.comInternet = :comInternet"),
    @NamedQuery(name = "Imovel.findByComChurrasqueira", 	query = "SELECT i FROM Imovel i WHERE i.comChurrasqueira = :comChurrasqueira"),
    @NamedQuery(name = "Imovel.findByComLareira", 			query = "SELECT i FROM Imovel i WHERE i.comLareira = :comLareira"),
    @NamedQuery(name = "Imovel.findByComSacada", 			query = "SELECT i FROM Imovel i WHERE i.comSacada = :comSacada"),
    @NamedQuery(name = "Imovel.findByComGaragem", 			query = "SELECT i FROM Imovel i WHERE i.comGaragem = :comGaragem"),
    @NamedQuery(name = "Imovel.findByBanheirocomunitario", 	query = "SELECT i FROM Imovel i WHERE i.banheiroComunitario = :banheiroComunitario"),
    @NamedQuery(name = "Imovel.findByCozinhaComunitaria", 	query = "SELECT i FROM Imovel i WHERE i.cozinhaComunitaria = :cozinhaComunitaria")})
public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="tipo_imovel", length=255)
	private String tipoImovel;

	@Column(length=255)
	private String cidade;

	@Column(length=255)
	private String logradouro;

	@Column(length=255)
	private String endereco;

	@Column(length=255)
	private String numero;

	@Column(length=255)
	private String bairro;

	@Column(name="num_comodos")
	private Integer numComodos;

	@Column(name="num_banheiros")
	private Integer numBanheiros;

	@Column(name="mobiliado")
	private Boolean mobiliado;

	@Column(name="com_varanda")
	private Boolean comVaranda;

	@Column(name="com_quintal")
	private Boolean comQuintal;

	@Column(name="com_internet")
	private Boolean comInternet;

	@Column(name="com_churrasqueira")
	private Boolean comChurrasqueira;

	@Column(name="com_lareira")
	private Boolean comLareira;

	@Column(name="com_sacada")
	private Boolean comSacada;

	@Column(name="com_garagem")
	private Boolean comGaragem;

	@Column(name="banheiro_comunitario")
	private Boolean banheiroComunitario;

	@Column(name="cozinha_comunitaria")
	private Boolean cozinhaComunitaria;

	//bi-directional many-to-one association to Quarto
	@OneToMany(mappedBy="imovel")
	private List<Quarto> quartos;

	//bi-directional many-to-one association to Quarto
	@OneToMany(mappedBy="imovel")
	private List<Quarto> vagas;

    public Imovel() {
    	
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Boolean getBanheiroComunitario() {
		return this.banheiroComunitario;
	}

	public void setBanheiroComunitario(Boolean banheiroComunitario) {
		this.banheiroComunitario = banheiroComunitario;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Boolean getComChurrasqueira() {
		return this.comChurrasqueira;
	}

	public void setComChurrasqueira(Boolean comChurrasqueira) {
		this.comChurrasqueira = comChurrasqueira;
	}

	public Boolean getComGaragem() {
		return this.comGaragem;
	}

	public void setComGaragem(Boolean comGaragem) {
		this.comGaragem = comGaragem;
	}

	public Boolean getComInternet() {
		return this.comInternet;
	}

	public void setComInternet(Boolean comInternet) {
		this.comInternet = comInternet;
	}

	public Boolean getComLareira() {
		return this.comLareira;
	}

	public void setComLareira(Boolean comLareira) {
		this.comLareira = comLareira;
	}

	public Boolean getComQuintal() {
		return this.comQuintal;
	}

	public void setComQuintal(Boolean comQuintal) {
		this.comQuintal = comQuintal;
	}

	public Boolean getComSacada() {
		return this.comSacada;
	}

	public void setComSacada(Boolean comSacada) {
		this.comSacada = comSacada;
	}

	public Boolean getComVaranda() {
		return this.comVaranda;
	}

	public void setComVaranda(Boolean comVaranda) {
		this.comVaranda = comVaranda;
	}

	public Boolean getCozinhaComunitaria() {
		return this.cozinhaComunitaria;
	}

	public void setCozinhaComunitaria(Boolean cozinhaComunitaria) {
		this.cozinhaComunitaria = cozinhaComunitaria;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Boolean getMobiliado() {
		return this.mobiliado;
	}

	public void setMobiliado(Boolean mobiliado) {
		this.mobiliado = mobiliado;
	}

	public Integer getNumBanheiros() {
		return this.numBanheiros;
	}

	public void setNumBanheiros(Integer numBanheiros) {
		this.numBanheiros = numBanheiros;
	}

	public Integer getNumComodos() {
		return this.numComodos;
	}

	public void setNumComodos(Integer numComodos) {
		this.numComodos = numComodos;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoImovel() {
		return this.tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public List<Quarto> getQuartos() {
		return this.quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

    public List<Quarto> getVagas() {
		return vagas;
	}

	public void setVagas(List<Quarto> vagas) {
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
        if (!(object instanceof Imovel)) {
            return false;
        }
        Imovel other = (Imovel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Imovel[ id=" + id + " ]";
    }
	
}