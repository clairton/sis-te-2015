package br.edu.horus;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.Before;
import org.junit.Test;

public class PessoaTest {
	private EntityManager em;
	
	@Before
	public void init(){
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("default");
		em = emf.createEntityManager();
//		em.persist(new Pessoa("Pedro", new Date()));
//		em.persist(new Pessoa("Antônio", new Date()));
//		em.persist(new Pessoa("José", new Date()));
	}
	
	@Test
	public void test() {
		Pessoa pessoa = new Pessoa("João", new Date());
		em.persist(pessoa);
	}
	
	@Test
	public void testConsulta(){
		Pessoa pessoa = new Pessoa("Adão", new Date());
		Documento cpf = new Cpf("643.601.021-19", pessoa);
		em.persist(cpf);
		Documento rg = new Rg("12345", "SSP", pessoa);
		em.persist(rg);
		em.getTransaction().begin();
		em.flush();
		em.getTransaction().commit();
		
		String jpql = "Select p From Pessoa p JOIN FETCH p.documentos";
		Query query = em.createQuery(jpql);
		List<Pessoa> pessoas = query.getResultList();
		for (Pessoa p : pessoas) {
			System.out.println(p.getNome());
			for(Documento d : p.getDocumentos()){
				System.err.println(d.getValor());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testSelect(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> query = builder.createQuery(Pessoa.class);
		Root<Pessoa> from = query.from(Pessoa.class);
		TypedQuery<Pessoa> createQuery = em.createQuery(query);
		List<Pessoa> list = createQuery.getResultList();
		for (Pessoa pessoa : list) {
			System.out.println(pessoa.getNome());
		}
	}
}
