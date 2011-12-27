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
		System.out.print("usuario: ");
		System.out.println(usuario.getNome());
		if(!usuario.getInquilinos().isEmpty()) {
			System.out.print("moradia: ");
			System.out.println(usuario.getInquilinos().get(0).getVaga().getMensalidade());
		}
		if(!usuario.getProprietarios().isEmpty()) {
			System.out.print("propriedades: ");
			System.out.println(usuario.getProprietarios().get(0).getImovel().getEndereco());
		}
		if(!usuario.getInteresses().isEmpty()) {
			System.out.println("interesse:");
			for(int i=0; i<usuario.getInteresses().size(); i++) {
				System.out.println(usuario.getInteresses().get(i).getVaga().getMensalidade());
			}
		}
		
		em = PersistenceFactory.getEntityManager();
		//Session session = PersistenceFactory.getSession();
		EntityTransaction transaction = em.getTransaction();
		//Transaction transaction = session.beginTransaction();
		try {
			transaction.begin();
			em.persist(usuario);
			//session.persist(usuario);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
			//session.close();
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
		
		InteresseVaga interesseVaga1 = new InteresseVaga();
		InteresseVaga interesseVaga2 = new InteresseVaga();
		InteresseVaga interesseVaga3 = new InteresseVaga();
		InteresseVaga interesseVaga4 = new InteresseVaga();
		InteresseVaga interesseVaga5 = new InteresseVaga();
		InteresseVaga interesseVaga6 = new InteresseVaga();
		InteresseVaga interesseVaga7 = new InteresseVaga();
		InteresseVaga interesseVaga8 = new InteresseVaga();
		
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
		usuario2.setInteresses(new ArrayList<InteresseVaga>());
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
		usuario3.setInteresses(new ArrayList<InteresseVaga>());
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
		usuario4.setInteresses(new ArrayList<InteresseVaga>());
		usuario4.setProprietarios(new ArrayList<Proprietario>());
		usuario4.setInquilinos(new ArrayList<Inquilino>());
		
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
		vaga2.setInquilino(new Inquilino());
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
		vaga4.setInquilino(new Inquilino());
		vaga4.setInteresses(new ArrayList<InteresseVaga>());
		
		vaga5.setMensalidade(250.0);
		vaga5.setServicosIncluidos("");
		vaga5.setServicosNaoIncluidos("faxina, lavagem de roupas");
		vaga5.setDespesasAdicionais(50.0);
		vaga5.setInquilino(new Inquilino());
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
		usuario1.getProprietarios().add(imovel1.getProprietario());
		
		imovel2.getProprietario().setUsuario(usuario1);
		imovel2.getProprietario().setImovel(imovel2);
		usuario1.getProprietarios().add(imovel2.getProprietario());

		interesseVaga1.setUsuario(usuario1);
		interesseVaga2.setUsuario(usuario2);
		interesseVaga3.setUsuario(usuario3);
		interesseVaga4.setUsuario(usuario3);
		interesseVaga5.setUsuario(usuario4);
		interesseVaga6.setUsuario(usuario4);
		interesseVaga7.setUsuario(usuario4);
		interesseVaga8.setUsuario(usuario4);
		
		interesseVaga1.setVaga(vaga3);
		interesseVaga2.setVaga(vaga5);
		interesseVaga3.setVaga(vaga4);
		interesseVaga4.setVaga(vaga2);
		interesseVaga5.setVaga(vaga5);
		interesseVaga6.setVaga(vaga4);
		interesseVaga7.setVaga(vaga3);
		interesseVaga8.setVaga(vaga1);
		
		usuario1.getInteresses().add(interesseVaga1);
		usuario2.getInteresses().add(interesseVaga2);
		usuario3.getInteresses().add(interesseVaga3);
		usuario3.getInteresses().add(interesseVaga4);
		usuario4.getInteresses().add(interesseVaga5);
		usuario4.getInteresses().add(interesseVaga6);
		usuario4.getInteresses().add(interesseVaga7);
		usuario4.getInteresses().add(interesseVaga8);
		
		vaga1.getInteresses().add(interesseVaga8);
		vaga2.getInteresses().add(interesseVaga4);
		vaga3.getInteresses().add(interesseVaga1);
		vaga3.getInteresses().add(interesseVaga7);
		vaga4.getInteresses().add(interesseVaga3);
		vaga4.getInteresses().add(interesseVaga6);
		vaga5.getInteresses().add(interesseVaga2);
		vaga5.getInteresses().add(interesseVaga5);
		
		vaga1.getInquilino().setUsuario(usuario2);
		vaga1.getInquilino().setVaga(vaga1);
		
		vaga2.getInquilino().setUsuario(usuario4);
		vaga2.getInquilino().setVaga(vaga2);
		
		vaga3.getInquilino().setUsuario(usuario3);
		vaga3.getInquilino().setVaga(vaga3);
		
		vaga4.getInquilino().setUsuario(usuario1);
		vaga4.getInquilino().setVaga(vaga4);
		
		vaga5.getInquilino().setUsuario(usuario4);
		vaga5.getInquilino().setVaga(vaga5);
		
		usuario1.getInquilinos().add(vaga4.getInquilino());
		usuario2.getInquilinos().add(vaga1.getInquilino());
		usuario3.getInquilinos().add(vaga3.getInquilino());
		usuario4.getInquilinos().add(vaga2.getInquilino());
		usuario4.getInquilinos().add(vaga4.getInquilino());
		
		usuarioDao.insert(usuario1);
		usuarioDao.insert(usuario2);
		usuarioDao.insert(usuario3);
		usuarioDao.insert(usuario4);
		
		imovelDao.insert(imovel1);
		imovelDao.insert(imovel2);
		
	}
	
}
