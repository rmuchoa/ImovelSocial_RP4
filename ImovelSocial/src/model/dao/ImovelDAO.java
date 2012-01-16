package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.PersistenceFactory;
import model.entity.Imovel;

public class ImovelDAO {
	
	private EntityManager em;
	
	public ImovelDAO() {
		em = PersistenceFactory.getEntityManager();
	}
	
	public boolean insert(Imovel imovel) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(imovel);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean update(Imovel imovel) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(imovel);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean delete(Imovel imovel) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(imovel);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public Imovel selectById(Long id) {
		Imovel i = em.find(Imovel.class, id);
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public List<Imovel> selectAll() {
        String hql = "from " + Imovel.class.getSimpleName();
        Query query = em.createQuery(hql);
        return (List<Imovel>) query.getResultList();
	}
	
	public static void main (String[] args) {
		ImovelDAO idao = new ImovelDAO();
		List<Imovel> imoveis = idao.selectAll();
		for (int i=0; i<imoveis.size(); i++) {
			System.out.println(imoveis.get(i).getLogradouro() + " " + imoveis.get(i).getEndereco());
		}
	}

}
