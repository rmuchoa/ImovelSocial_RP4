package br.com.unipampa.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private ArrayList<InteresseVaga> interesses;
	private Proprietario proprietario;
	private Inquilino inquilino;
	private Locatario locatario;
	private Locador locador;
	
	public Usuario() {
		
	}
	
	@Id
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

	@OneToMany
	public ArrayList<InteresseVaga> getInteresse() {
		return interesses;
	}

	public void setInteresse(ArrayList<InteresseVaga> interesses) {
		this.interesses = interesses;
	}

	@OneToOne
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@OneToOne
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	@OneToOne
	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}

	@OneToOne
	public Locador getLocador() {
		return locador;
	}

	public void setLocador(Locador locador) {
		this.locador = locador;
	}
	
}
