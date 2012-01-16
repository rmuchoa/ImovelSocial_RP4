package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.PersistenceFactory;
import model.entity.Usuario;

public class UsuarioDAO {
	
	private EntityManager em;
	
	public UsuarioDAO() {
		em = PersistenceFactory.getEntityManager();
	}
	
	public boolean insert(Usuario usuario) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(usuario);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean update(Usuario usuario) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			usuario = em.merge(usuario);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public boolean delete(Usuario usuario) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(usuario);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
	
	public Usuario selectById(Long id) {
		Usuario u = em.find(Usuario.class, id);
		return u;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> selectAll() {
        String hql = "from " + Usuario.class.getSimpleName();
        Query query = em.createQuery(hql);
        return (List<Usuario>)query.getResultList();
	}
	
	public static void main (String[] args) {
		UsuarioDAO udao = new UsuarioDAO();
		List<Usuario> usuarios = udao.selectAll();
		for (int i=0; i<usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getNome() + " " + usuarios.get(i).getEscolaridade());
		}
	}
	
}
