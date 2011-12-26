package br.com.unipampa.model.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.unipampa.model.PersistenceFactory;
import br.com.unipampa.model.entity.Imovel;
import br.com.unipampa.model.entity.Inquilino;
import br.com.unipampa.model.entity.InteresseVaga;
import br.com.unipampa.model.entity.Proprietario;
import br.com.unipampa.model.entity.Quarto;
import br.com.unipampa.model.entity.Usuario;
import br.com.unipampa.model.entity.Vaga;
import br.com.unipampa.model.entity.enumeration.Escolaridade;
import br.com.unipampa.model.entity.enumeration.Sexo;
import br.com.unipampa.model.entity.enumeration.TipoQuarto;

public class UsuarioDAO {
	
	private EntityManager em;
	
	public UsuarioDAO() {
		
	}
	
	@SuppressWarnings("finally")
	public Usuario insert(Usuario usuario) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(usuario);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
			return usuario;
		}
	}
	
	@SuppressWarnings("finally")
	public Usuario update(Usuario usuario) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			usuario = em.merge(usuario);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
			return usuario;
		}
	}
	
	@SuppressWarnings("finally")
	public Usuario delete(Usuario usuario) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(usuario);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
			return usuario;
		}
	}
	
	public Usuario selectById(int id) {
		em = PersistenceFactory.getEntityManager();
		Usuario u = em.find(Usuario.class, id);
		em.close();
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> selectAll() {
        em = PersistenceFactory.getEntityManager();
        String hql = "from " + Usuario.class.getSimpleName();
        Query query = em.createQuery(hql);
        return query.getResultList();
	}

	public static void main(String[] args) {
		
		UsuarioDAO udao = new UsuarioDAO();
		ImovelDAO idao = new ImovelDAO();
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		Usuario usuario4 = new Usuario();
		
		Imovel imovel1 = new Imovel();
		Imovel imovel2 = new Imovel();
		
		Quarto quarto1 = new Quarto();
		Quarto quarto2 = new Quarto();
		Quarto quarto3 = new Quarto();
		Quarto quarto4 = new Quarto();
		
		Vaga vaga1 = new Vaga();
		Vaga vaga2 = new Vaga();
		Vaga vaga3 = new Vaga();
		Vaga vaga4 = new Vaga();
		Vaga vaga5 = new Vaga();
		
		InteresseVaga interesseVaga1 = new InteresseVaga();
		InteresseVaga interesseVaga2 = new InteresseVaga();
		InteresseVaga interesseVaga3 = new InteresseVaga();
		InteresseVaga interesseVaga4 = new InteresseVaga();
		
		usuario1.setLogin("renan");
		usuario1.setSenha("12345");
		usuario1.setEmail("renanuchoa@email.com");
		usuario1.setAtivo(true);
		usuario1.setNome("Renan Uchôa");
		usuario1.setSexo(Sexo.MASCULINO);
		usuario1.setDataNascimento(new GregorianCalendar().getTime());
		usuario1.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario1.setFumante(false);
		usuario1.setInteresses(new ArrayList<InteresseVaga>());
		usuario1.setProprietario(new ArrayList<Proprietario>());
		usuario1.setInquilino(new ArrayList<Inquilino>());
		
		usuario2.setLogin("lucas");
		usuario2.setSenha("12345");
		usuario2.setEmail("lucascapanelli@email.com");
		usuario2.setAtivo(true);
		usuario2.setNome("Lucas Capanelli");
		usuario2.setSexo(Sexo.MASCULINO);
		usuario2.setDataNascimento(new GregorianCalendar().getTime());
		usuario2.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario2.setFumante(false);
		usuario2.setInteresses(new ArrayList<InteresseVaga>());
		usuario2.setProprietario(new ArrayList<Proprietario>());
		usuario2.setInquilino(new ArrayList<Inquilino>());
		
		usuario3.setLogin("libero");
		usuario3.setSenha("12345");
		usuario3.setEmail("liberorodrigues");
		usuario3.setAtivo(true);
		usuario3.setNome("Líbero Rodrigues");
		usuario3.setSexo(Sexo.MASCULINO);
		usuario3.setDataNascimento(new GregorianCalendar().getTime());
		usuario3.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario3.setFumante(true);
		usuario3.setInteresses(new ArrayList<InteresseVaga>());
		usuario3.setProprietario(new ArrayList<Proprietario>());
		usuario3.setInquilino(new ArrayList<Inquilino>());
		
		usuario4.setLogin("leandro");
		usuario4.setSenha("12345");
		usuario4.setEmail("leandroamaral@email.com");
		usuario4.setAtivo(true);
		usuario4.setNome("Leandro Amaral");
		usuario4.setSexo(Sexo.MASCULINO);
		usuario4.setDataNascimento(new GregorianCalendar().getTime());
		usuario4.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario4.setFumante(false);
		usuario4.setInteresses(new ArrayList<InteresseVaga>());
		usuario4.setProprietario(new ArrayList<Proprietario>());
		usuario4.setInquilino(new ArrayList<Inquilino>());
		
		imovel1.setEndereco("R. dos Bobos, 0");
		imovel1.setNumComodos(5);
		imovel1.setNumBanheiros(2);
		imovel1.setMobiliado(true);
		imovel1.setComQuintal(false);
		imovel1.setComVaranda(true);
		imovel1.setComInternet(true);
		imovel1.setQuartos(new ArrayList<Quarto>());
		imovel1.setProprietario(new Proprietario());
		
		imovel2.setEndereco("R. das Flores, 150");
		imovel2.setNumComodos(2);
		imovel2.setNumBanheiros(1);
		imovel2.setMobiliado(false);
		imovel2.setComQuintal(false);
		imovel2.setComVaranda(false);
		imovel2.setComInternet(true);
		imovel2.setQuartos(new ArrayList<Quarto>());
		imovel2.setProprietario(new Proprietario());
		
		quarto1.setTipoQuarto(TipoQuarto.SOLTEIRO);
		quarto1.setVagas(new ArrayList<Vaga>());
		quarto1.setMobiliado(true);
		quarto1.setSuite(false);
		
		quarto2.setTipoQuarto(TipoQuarto.SOLTEIRO);
		quarto2.setVagas(new ArrayList<Vaga>());
		quarto2.setMobiliado(true);
		quarto2.setSuite(false);
		
		quarto3.setTipoQuarto(TipoQuarto.CASAL);
		quarto3.setVagas(new ArrayList<Vaga>());
		quarto3.setMobiliado(true);
		quarto3.setSuite(true);
		
		quarto4.setTipoQuarto(TipoQuarto.CONJUNTO);
		quarto4.setVagas(new ArrayList<Vaga>());
		quarto4.setMobiliado(false);
		quarto4.setSuite(false);
		
		vaga1.setMensalidade(300.0);
		vaga1.setServicosIncluidos("faxina");
		vaga1.setServicosNaoIncluidos("lavagem de roupas");
		vaga1.setDespesasAdicionais(0.0);
		vaga1.setInquilino(new Inquilino());
		vaga1.setInteresses(new ArrayList<InteresseVaga>());
		
		vaga2.setMensalidade(300.0);
		vaga2.setServicosIncluidos("faxina");
		vaga2.setServicosNaoIncluidos("lavagem de roupas");
		vaga2.setDespesasAdicionais(0.0);
		vaga2.setInteresses(new ArrayList<InteresseVaga>());
		
		vaga3.setMensalidade(450.0);
		vaga3.setServicosIncluidos("faxina");
		vaga3.setServicosNaoIncluidos("lavagem de roupas");
		vaga3.setDespesasAdicionais(0.0);
		vaga3.setInquilino(new Inquilino());
		vaga3.setInteresses(new ArrayList<InteresseVaga>());
		
		vaga4.setMensalidade(250.0);
		vaga4.setServicosIncluidos("");
		vaga4.setServicosNaoIncluidos("faxina, lavagem de roupas");
		vaga4.setDespesasAdicionais(50.0);
		vaga4.setInteresses(new ArrayList<InteresseVaga>());
		
		vaga5.setMensalidade(250.0);
		vaga5.setServicosIncluidos("");
		vaga5.setServicosNaoIncluidos("faxina, lavagem de roupas");
		vaga5.setDespesasAdicionais(50.0);
		vaga5.setInteresses(new ArrayList<InteresseVaga>());
		
		quarto1.getVagas().add(vaga1);
		quarto2.getVagas().add(vaga2);
		quarto3.getVagas().add(vaga3);
		
		imovel1.getQuartos().add(quarto1);
		imovel1.getQuartos().add(quarto2);
		imovel1.getQuartos().add(quarto3);

		quarto4.getVagas().add(vaga4);
		quarto4.getVagas().add(vaga5);
		
		imovel2.getQuartos().add(quarto4);
		
		imovel1.getProprietario().setUsuario(usuario1);
		imovel1.getProprietario().setImovel(imovel1);
		usuario1.getProprietario().add(imovel1.getProprietario());
		
		imovel2.getProprietario().setUsuario(usuario1);
		imovel2.getProprietario().setImovel(imovel2);
		usuario1.getProprietario().add(imovel2.getProprietario());
		
		interesseVaga1.setUsuario(usuario2);
		interesseVaga2.setUsuario(usuario3);
		interesseVaga3.setUsuario(usuario4);
		interesseVaga4.setUsuario(usuario4);
		
		interesseVaga1.setVaga(vaga5);
		interesseVaga2.setVaga(vaga4);
		interesseVaga3.setVaga(vaga2);
		interesseVaga4.setVaga(vaga5);
		
		usuario2.getInteresses().add(interesseVaga1);
		usuario3.getInteresses().add(interesseVaga2);
		usuario4.getInteresses().add(interesseVaga3);
		usuario4.getInteresses().add(interesseVaga4);
		
		vaga2.getInteresses().add(interesseVaga3);
		vaga4.getInteresses().add(interesseVaga2);
		vaga5.getInteresses().add(interesseVaga1);
		vaga5.getInteresses().add(interesseVaga4);
		
		vaga1.getInquilino().setUsuario(usuario2);
		vaga1.getInquilino().setVaga(vaga1);
		
		vaga3.getInquilino().setUsuario(usuario3);
		vaga3.getInquilino().setVaga(vaga3);
		
		usuario2.getInquilino().add(vaga1.getInquilino());
		usuario3.getInquilino().add(vaga3.getInquilino());
		
		udao.insert(usuario1);
		udao.insert(usuario2);
		udao.insert(usuario3);
		udao.insert(usuario4);
		
		idao.insert(imovel1);
		idao.insert(imovel2);
		
	}
	
}
