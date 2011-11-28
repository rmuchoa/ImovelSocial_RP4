package br.com.unipampa.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactory {

	private static EntityManagerFactory EntityManagerFactory;
    
    private static EntityManagerFactory getEntityManagerFactory() {
    	if (EntityManagerFactory == null) {
            EntityManagerFactory = Persistence.createEntityManagerFactory("ImovelSocialPU");
    	}
    	return EntityManagerFactory;
    }
    
    public static EntityManager getEntityManager() {
    	return getEntityManagerFactory().createEntityManager();
    }
	
}
