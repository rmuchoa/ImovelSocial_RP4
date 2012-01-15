package br.com.unipampa.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class PersistenceFactory {

	private static EntityManagerFactory emf;
	private static SessionFactory sf;
    
    private static EntityManagerFactory getEntityManagerFactory() {
    	if (emf == null) {
            emf = Persistence.createEntityManagerFactory("ImovelSocialPU");
    	}
    	return emf;
    }
    
    private static SessionFactory getSessionFactory() {
    	if(sf == null) {
    		try {
    			AnnotationConfiguration cfg = new AnnotationConfiguration();
    			cfg.configure("hibernate.cfg.xml");
    			sf = cfg.buildSessionFactory();
    		} catch (Throwable ex) {
    			System.err.println("Initial SessionFactory creation failed." + ex);
    			throw new ExceptionInInitializerError(ex);
    		}
    	}
		return sf;
    }
    
    public static EntityManager getEntityManager() {
    	return getEntityManagerFactory().createEntityManager();
    }
    
    public static Session getSession() {
    	return getSessionFactory().openSession();
    }
	
}
