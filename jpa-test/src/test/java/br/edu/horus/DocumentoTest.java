package br.edu.horus;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTest {
	private EntityManager em;
	private Pessoa pessoa;
	
	@Before
	public void init() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("default");
		em = emf.createEntityManager();
		pessoa = new Pessoa("Pedro", new Date());
		em.persist(pessoa);
	}

	@Test
	public void test() {
		Documento cpf = new Documento("999.888.888-00", pessoa);
		em.persist(cpf);
		em.getTransaction().begin();
		em.flush();
		em.getTransaction().commit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
