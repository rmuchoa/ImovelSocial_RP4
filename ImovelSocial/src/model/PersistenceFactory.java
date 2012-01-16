package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactory {

	private static EntityManagerFactory emf;
	private static EntityManager em;
    
    static {
    	if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ImovelSocialPU");
            em 	= emf.createEntityManager();
    	}
    }
    
    public static EntityManager getEntityManager() {
    	return em;
    }
	
}
