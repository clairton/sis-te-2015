package br.com.caelum.vraptor.controller;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transactional
@Interceptor
public class TransactionalInterceptor implements Serializable{
	

	private final EntityManager entityManager;
	
	@Inject
	public TransactionalInterceptor(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}




	@AroundInvoke
    public Object jaguara(InvocationContext invocationContext) 
    		throws Exception {

		entityManager.getTransaction().begin();
		Object r = invocationContext.proceed();
		entityManager.flush();
		entityManager.getTransaction().commit();
		
		return r;
    }
	
}
