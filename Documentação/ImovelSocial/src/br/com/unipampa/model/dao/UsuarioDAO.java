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
import br.com.unipampa.model.entity.Interesse;
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
	
	public Usuario insert(Usuario usuario) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(usuario);
			em.flush();
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
		em.close();
		return usuario;
	}
	
	public Usuario update(Usuario usuario) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			usuario = em.merge(usuario);
			em.flush();
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		em.close();
		return usuario;
	}
	
	public Usuario delete(Usuario usuario) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(usuario);
			em.flush();
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		em.close();
		return usuario;
	}
	
	public Usuario selectById(Long id) {
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
        return (List<Usuario>)query.getResultList();
	}

	public static void main(String[] args) {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ImovelDAO imovelDao = new ImovelDAO();
		
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
		
		Interesse interesse1 = new Interesse();
		Interesse interesse2 = new Interesse();
		Interesse interesse3 = new Interesse();
		Interesse interesse4 = new Interesse();
		Interesse interesse5 = new Interesse();
		Interesse interesse6 = new Interesse();
		Interesse interesse7 = new Interesse();
		Interesse interesse8 = new Interesse();
		
		usuario1.setLogin("renan");
		usuario1.setSenha("12345");
		usuario1.setEmail("renanuchoa@email.com");
		usuario1.setAtivo(true);
		usuario1.setNome("Renan Uchôa");
		usuario1.setSexo(Sexo.MASCULINO);
		usuario1.setDataNascimento(new GregorianCalendar().getTime());
		usuario1.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario1.setFumante(false);
		usuario1.setInteresses(new ArrayList<Interesse>());
		usuario1.setProprietarios(new ArrayList<Proprietario>());
		usuario1.setInquilinos(new ArrayList<Inquilino>());
		
		usuario2.setLogin("lucas");
		usuario2.setSenha("12345");
		usuario2.setEmail("lucascapanelli@email.com");
		usuario2.setAtivo(true);
		usuario2.setNome("Lucas Capanelli");
		usuario2.setSexo(Sexo.MASCULINO);
		usuario2.setDataNascimento(new GregorianCalendar().getTime());
		usuario2.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario2.setFumante(false);
		usuario2.setInteresses(new ArrayList<Interesse>());
		usuario2.setProprietarios(new ArrayList<Proprietario>());
		usuario2.setInquilinos(new ArrayList<Inquilino>());
		
		usuario3.setLogin("libero");
		usuario3.setSenha("12345");
		usuario3.setEmail("liberorodrigues");
		usuario3.setAtivo(true);
		usuario3.setNome("Líbero Rodrigues");
		usuario3.setSexo(Sexo.MASCULINO);
		usuario3.setDataNascimento(new GregorianCalendar().getTime());
		usuario3.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario3.setFumante(true);
		usuario3.setInteresses(new ArrayList<Interesse>());
		usuario3.setProprietarios(new ArrayList<Proprietario>());
		usuario3.setInquilinos(new ArrayList<Inquilino>());
		
		usuario4.setLogin("leandro");
		usuario4.setSenha("12345");
		usuario4.setEmail("leandroamaral@email.com");
		usuario4.setAtivo(true);
		usuario4.setNome("Leandro Amaral");
		usuario4.setSexo(Sexo.MASCULINO);
		usuario4.setDataNascimento(new GregorianCalendar().getTime());
		usuario4.setEscolaridade(Escolaridade.MEDIO_COMPLETO);
		usuario4.setFumante(false);
		usuario4.setInteresses(new ArrayList<Interesse>());
		usuario4.setProprietarios(new ArrayList<Proprietario>());
		usuario4.setInquilinos(new ArrayList<Inquilino>());
		
		interesse1.setUsuario(usuario1);
		interesse2.setUsuario(usuario2);
		interesse3.setUsuario(usuario3);
		interesse4.setUsuario(usuario3);
		interesse5.setUsuario(usuario4);
		interesse6.setUsuario(usuario4);
		interesse7.setUsuario(usuario4);
		interesse8.setUsuario(usuario4);
		
		usuario1.getInteresses().add(interesse1);
		usuario2.getInteresses().add(interesse2);
		usuario3.getInteresses().add(interesse3);
		usuario3.getInteresses().add(interesse4);
		usuario4.getInteresses().add(interesse5);
		usuario4.getInteresses().add(interesse6);
		usuario4.getInteresses().add(interesse7);
		usuario4.getInteresses().add(interesse8);
		
		/*imovel1.setEndereco("R. dos Bobos, 0");
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
		quarto1.setImovel(imovel1);
		
		quarto2.setTipoQuarto(TipoQuarto.SOLTEIRO);
		quarto2.setVagas(new ArrayList<Vaga>());
		quarto2.setMobiliado(true);
		quarto2.setSuite(false);
		quarto2.setImovel(imovel1);
		
		quarto3.setTipoQuarto(TipoQuarto.CASAL);
		quarto3.setVagas(new ArrayList<Vaga>());
		quarto3.setMobiliado(true);
		quarto3.setSuite(true);
		quarto3.setImovel(imovel1);
		
		quarto4.setTipoQuarto(TipoQuarto.CONJUNTO);
		quarto4.setVagas(new ArrayList<Vaga>());
		quarto4.setMobiliado(false);
		quarto4.setSuite(false);
		quarto4.setImovel(imovel2);
		
		vaga1.setMensalidade(300.0);
		vaga1.setServicosIncluidos("faxina");
		vaga1.setServicosNaoIncluidos("lavagem de roupas");
		vaga1.setDespesasAdicionais(0.0);
		vaga1.setQuarto(quarto1);
		vaga1.setInquilino(new Inquilino());
		vaga1.setInteresses(new ArrayList<Interesse>());
		
		vaga2.setMensalidade(300.0);
		vaga2.setServicosIncluidos("faxina");
		vaga2.setServicosNaoIncluidos("lavagem de roupas");
		vaga2.setDespesasAdicionais(0.0);
		vaga2.setQuarto(quarto2);
		vaga2.setInquilino(new Inquilino());
		vaga2.setInteresses(new ArrayList<Interesse>());
		
		vaga3.setMensalidade(450.0);
		vaga3.setServicosIncluidos("faxina");
		vaga3.setServicosNaoIncluidos("lavagem de roupas");
		vaga3.setDespesasAdicionais(0.0);
		vaga3.setQuarto(quarto3);
		vaga3.setInquilino(new Inquilino());
		vaga3.setInteresses(new ArrayList<Interesse>());
		
		vaga4.setMensalidade(250.0);
		vaga4.setServicosIncluidos("");
		vaga4.setServicosNaoIncluidos("faxina, lavagem de roupas");
		vaga4.setDespesasAdicionais(50.0);
		vaga4.setQuarto(quarto4);
		vaga4.setInquilino(new Inquilino());
		vaga4.setInteresses(new ArrayList<Interesse>());
		
		vaga5.setMensalidade(250.0);
		vaga5.setServicosIncluidos("");
		vaga5.setServicosNaoIncluidos("faxina, lavagem de roupas");
		vaga5.setDespesasAdicionais(50.0);
		vaga5.setQuarto(quarto4);
		vaga5.setInquilino(new Inquilino());
		vaga5.setInteresses(new ArrayList<Interesse>());
		
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
		usuario1.getProprietarios().add(imovel1.getProprietario());
		
		imovel2.getProprietario().setUsuario(usuario1);
		imovel2.getProprietario().setImovel(imovel2);
		usuario1.getProprietarios().add(imovel2.getProprietario());
		
		vaga1.getInquilino().setUsuario(usuario2);
		vaga2.getInquilino().setUsuario(usuario4);
		vaga3.getInquilino().setUsuario(usuario3);
		vaga4.getInquilino().setUsuario(usuario1);
		vaga5.getInquilino().setUsuario(usuario4);
		
		vaga1.getInquilino().setVaga(vaga1);
		vaga2.getInquilino().setVaga(vaga2);
		vaga3.getInquilino().setVaga(vaga3);
		vaga4.getInquilino().setVaga(vaga4);
		vaga5.getInquilino().setVaga(vaga5);
		
		usuario1.getInquilinos().add(vaga4.getInquilino());
		usuario2.getInquilinos().add(vaga1.getInquilino());
		usuario3.getInquilinos().add(vaga3.getInquilino());
		usuario4.getInquilinos().add(vaga2.getInquilino());
		usuario4.getInquilinos().add(vaga5.getInquilino());

		interesse1.setUsuario(usuario1);
		interesse2.setUsuario(usuario2);
		interesse3.setUsuario(usuario3);
		interesse4.setUsuario(usuario3);
		interesse5.setUsuario(usuario4);
		interesse6.setUsuario(usuario4);
		interesse7.setUsuario(usuario4);
		interesse8.setUsuario(usuario4);
		
		interesse1.setVaga(vaga3);
		interesse2.setVaga(vaga5);
		interesse3.setVaga(vaga4);
		interesse4.setVaga(vaga2);
		interesse5.setVaga(vaga5);
		interesse6.setVaga(vaga4);
		interesse7.setVaga(vaga3);
		interesse8.setVaga(vaga1);
		
		usuario1.getInteresses().add(interesse1);
		usuario2.getInteresses().add(interesse2);
		usuario3.getInteresses().add(interesse3);
		usuario3.getInteresses().add(interesse4);
		usuario4.getInteresses().add(interesse5);
		usuario4.getInteresses().add(interesse6);
		usuario4.getInteresses().add(interesse7);
		usuario4.getInteresses().add(interesse8);
		
		vaga1.getInteresses().add(interesse8);
		vaga2.getInteresses().add(interesse4);
		vaga3.getInteresses().add(interesse1);
		vaga3.getInteresses().add(interesse7);
		vaga4.getInteresses().add(interesse3);
		vaga4.getInteresses().add(interesse6);
		vaga5.getInteresses().add(interesse2);
		vaga5.getInteresses().add(interesse5);*/
		
		usuarioDao.insert(usuario1);
		usuarioDao.insert(usuario2);
		usuarioDao.insert(usuario3);
		usuarioDao.insert(usuario4);
		
		//imovelDao.insert(imovel1);
		//imovelDao.insert(imovel2);
		
	}
	
}
