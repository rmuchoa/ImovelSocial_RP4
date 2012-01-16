package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.PersistenceFactory;
import model.entity.Interesse;

public class InteresseDAO {
	
	private EntityManager em;
	
	public InteresseDAO() {
		em = PersistenceFactory.getEntityManager();
	}
	
	public boolean insert(Interesse interesse) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(interesse);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean update(Interesse interesse) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			interesse = em.merge(interesse);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean delete(Interesse interesse) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(interesse);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public Interesse selectById(Long id) {
		Interesse interesse = em.find(Interesse.class, id);
		return interesse;
	}
	
	@SuppressWarnings("unchecked")
	public List<Interesse> selectAll() {
        String hql = "from " + Interesse.class.getSimpleName();
        Query query = em.createQuery(hql);
        return (List<Interesse>) query.getResultList();
	}
	
	public static void main (String[] args) {
		InteresseDAO idao = new InteresseDAO();
		List<Interesse> interesses = idao.selectAll();
		for (int i=0; i<interesses.size(); i++) {
			System.out.println(interesses.get(i).getUsuario().getNome() + " está interessado em ocupar 1 " + interesses.get(i).getVaga().getTipoVaga() + " de " + interesses.get(i).getVaga().getQuarto().getImovel().getTipoImovel() + " localizado no(a) " + interesses.get(i).getVaga().getQuarto().getImovel().getLogradouro() + " " + interesses.get(i).getVaga().getQuarto().getImovel().getEndereco());
		}
	}

}
