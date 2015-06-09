package br.com.caelum.vraptor.model;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	private EntityManagerFactory emf;

	@PostConstruct
	public void iniciar() {
		emf = Persistence.createEntityManagerFactory("default");

		
		
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(new Pessoa("João", new Date()));
		em.persist(new Pessoa("Maria", new Date()));
		
		
		em.flush();
		em.clear();
		em.getTransaction().commit();
	}

	@javax.enterprise.inject.Produces
	@javax.enterprise.context.RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
