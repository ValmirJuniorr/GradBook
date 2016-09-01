package br.com.valmirjunior.gradbook.model.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless(name="GenericDao")
public class GenericDao {
	@PersistenceContext
	protected EntityManager manager;		
	
	public <T> T getById(Class<T> t, int id) {
		return manager.find(t,id);
	}

	@Transactional
	public void merge(Object object) {
		this.manager.merge(object);
	}

	@Transactional
	public void remove(Object object) {
		this.manager.remove(this.manager.contains(object) ? object : manager.merge(object));
	}	
}
