package br.com.unipampa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.unipampa.model.PersistenceFactory;
import br.com.unipampa.model.entity.Imovel;

public class ImovelDAO {
	
	private EntityManager em;
	
	public ImovelDAO() {
		
	}
	
	public Imovel insert(Imovel imovel) {
		em = PersistenceFactory.getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(imovel);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		em.close();
		return imovel;
	}
	
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
		}
		em.close();
		return imovel;
	}
	
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
		}
		em.close();
		return imovel;
	}
	
	public Imovel selectById(Long id) {
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
        return (List<Imovel>) query.getResultList();
	}

}
