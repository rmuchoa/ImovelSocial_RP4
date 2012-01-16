package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.PersistenceFactory;
import model.entity.Quarto;

public class QuartoDAO {
	
	private EntityManager em;
	
	public QuartoDAO() {
		em = PersistenceFactory.getEntityManager();
	}
	
	public boolean insert(Quarto quarto) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(quarto);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean update(Quarto quarto) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			quarto = em.merge(quarto);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean delete(Quarto quarto) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(quarto);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public Quarto selectById(Long id) {
		Quarto quarto = em.find(Quarto.class, id);
		return quarto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Quarto> selectAll() {
        String hql = "from " + Quarto.class.getSimpleName();
        Query query = em.createQuery(hql);
        return (List<Quarto>) query.getResultList();
	}
	
	public static void main (String[] args) {
		QuartoDAO qdao = new QuartoDAO();
		List<Quarto> quartos = qdao.selectAll();
		for (int i=0; i<quartos.size(); i++) {
			System.out.println("Quarto " + quartos.get(i).getTipoQuarto() + " " + quartos.get(i).getVagas().size() + " vagas");
		}
	}

}
