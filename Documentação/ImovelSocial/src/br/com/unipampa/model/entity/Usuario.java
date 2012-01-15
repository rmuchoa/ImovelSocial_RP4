package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.unipampa.model.entity.enumeration.Escolaridade;
import br.com.unipampa.model.entity.enumeration.Sexo;

@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2029474619985699183L;
	
	private Long id;
	private String login;
	private String senha;
	private String email;
	private Boolean ativo;
	private String nome;
	private Date dataNascimento;
	private Integer idade;
	private Sexo sexo;
	private Boolean fumante;
	private Escolaridade escolaridade;
	private List<Interesse> interesses;
	private List<Proprietario> proprietarios;
	private List<Inquilino> inquilinos;
	
	public Usuario() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_generator")
	@SequenceGenerator(name="usuario_generator", sequenceName="usuario_sequence")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Transient
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Enumerated(EnumType.STRING)
	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Boolean isFumante() {
		return fumante;
	}
	
	public void setFumante(Boolean fumante) {
		this.fumante = fumante;
	}
	
	@Enumerated(EnumType.STRING)
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	@OneToMany(mappedBy="usuario", cascade={CascadeType.ALL})
	public List<Interesse> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<Interesse> interesses) {
		this.interesses = interesses;
	}

	@OneToMany(mappedBy="usuario", cascade={CascadeType.ALL})
	public List<Proprietario> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(List<Proprietario> proprietarios) {
		this.proprietarios = proprietarios;
	}

	@OneToMany(mappedBy="usuario", cascade={CascadeType.ALL})
	public List<Inquilino> getInquilinos() {
		return inquilinos;
	}

	public void setInquilinos(List<Inquilino> inquilinos) {
		this.inquilinos = inquilinos;
	}
	
}
