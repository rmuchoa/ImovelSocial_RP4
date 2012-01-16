package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.PersistenceFactory;
import model.entity.Vaga;

public class VagaDAO {
	
	private EntityManager em;
	
	public VagaDAO() {
		em = PersistenceFactory.getEntityManager();
	}
	
	public boolean insert(Vaga vaga) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(vaga);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean update(Vaga vaga) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			vaga = em.merge(vaga);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean delete(Vaga vaga) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(vaga);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public Vaga selectById(Long id) {
		Vaga vaga = em.find(Vaga.class, id);
		return vaga;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vaga> selectAll() {
        String hql = "from " + Vaga.class.getSimpleName();
        Query query = em.createQuery(hql);
        return (List<Vaga>) query.getResultList();
	}
	
	public static void main (String[] args) {
		VagaDAO vdao = new VagaDAO();
		List<Vaga> vagas = vdao.selectAll();
		for (int i=0; i<vagas.size(); i++) {
			System.out.println(vagas.get(i).getTipoVaga() + " por " + vagas.get(i).getMensalidade());
		}
	}

}
