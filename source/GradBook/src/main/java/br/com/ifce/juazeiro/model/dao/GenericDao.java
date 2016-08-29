package br.com.ifce.juazeiro.model.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name="GenericDao")
public class GenericDao {
	@PersistenceContext
	protected EntityManager manager;		
	
	public <T> T getById(Class<T> t, int id) {
		return manager.find(t,id);
	}
}
