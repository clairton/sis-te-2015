package br.com.caelum.vraptor.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.model.Pessoa;
import br.com.caelum.vraptor.view.Results;

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
	
	
	
	
	
	
	
	
	
	
}