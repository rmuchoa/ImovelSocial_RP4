package br.com.unipampa.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactory {

	private static EntityManagerFactory emf;
    
    private static EntityManagerFactory getEntityManagerFactory() {
    	if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ImovelSocialPU");
    	}
    	return emf;
    }
    
    public static EntityManager getEntityManager() {
    	return getEntityManagerFactory().createEntityManager();
    }
	
}
