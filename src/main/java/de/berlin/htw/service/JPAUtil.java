package de.berlin.htw.service;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManager em = Persistence.createEntityManagerFactory("bugtrackerContext").createEntityManager();

	public static EntityManager getEm() {
		return em;
	}
	
	
	
}
