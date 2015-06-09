package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.Pessoa;
import br.com.caelum.vraptor.serialization.gson.WithRoot;

@Controller
public class IndexController {

	private final Result result;
	private final javax.persistence.EntityManager entityManager;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null, null);
	}
	
	@Inject
	public IndexController(Result result, 
			javax.persistence.EntityManager entityManager) {
		this.result = result;
		this.entityManager = entityManager;
	}

	@Path("/")
	public List<Pessoa> index() {		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
		cq.from(Pessoa.class);
		TypedQuery<Pessoa> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	
	@Path("/{id}")
	public void show(Integer id){
		Pessoa pessoa = entityManager.find(Pessoa.class, id);
	    result.include("pessoa", pessoa);
	}

	/******************************************/
	@Get("/novo")
	public void novo(){
		
	}
	
	@Post("/create")
	public void create(Pessoa pessoa){
		entityManager.getTransaction().begin();
		entityManager.persist(pessoa);
		entityManager.flush();
		entityManager.getTransaction().commit();
		result.redirectTo(IndexController.class).index();
	}
	

	@Get("/delete/{id}")
	public void delete(Integer id){
		Pessoa pessoa = entityManager.find(Pessoa.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(pessoa);
		entityManager.flush();
		entityManager.clear();
		entityManager.getTransaction().commit();
		result.redirectTo(IndexController.class).index();
	}
	
	
	@Consumes(
			value={"application/x-www-form-urlencoded", "text/html"}, 
			options=WithRoot.class)
	@Post("/update")
	public void update(Pessoa pessoa){
		entityManager.getTransaction().begin();
		entityManager.merge(pessoa);
		entityManager.flush();
		entityManager.getTransaction().commit();
		result.redirectTo(IndexController.class).index();
	}
}