package br.com.unipampa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.unipampa.model.PersistenceFactory;
import br.com.unipampa.model.entity.Imovel;

public class ImovelDAO {
	
	private EntityManager em;
	
	public ImovelDAO() {
		
	}
	
	@SuppressWarnings("finally")
	public Imovel insert(Imovel imovel) {
		//em = PersistenceFactory.getEntityManager();
		Session session = PersistenceFactory.getSession();
		//EntityTransaction transaction = em.getTransaction();
		Transaction transaction = session.beginTransaction();
		try {
			//transaction.begin();
			//em.persist(usuario);
			session.persist(imovel);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			//em.close();
			session.close();
			return imovel;
		}
	}
	
	@SuppressWarnings("finally")
	public Imovel update(Imovel imovel) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			imovel = em.merge(imovel);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
			return imovel;
		}
	}
	
	@SuppressWarnings("finally")
	public Imovel delete(Imovel imovel) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(imovel);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
			return imovel;
		}
	}
	
	public Imovel selectById(int id) {
		em = PersistenceFactory.getEntityManager();
		Imovel i = em.find(Imovel.class, id);
		em.close();
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public List<Imovel> selectAll() {
        em = PersistenceFactory.getEntityManager();
        String hql = "from " + Imovel.class.getSimpleName();
        Query query = em.createQuery(hql);
        return query.getResultList();
	}

}
