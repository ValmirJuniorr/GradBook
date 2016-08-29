package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.valmirjunior.gradbook.model.Function;

@Stateless(name="FunctionDao")
public class FunctionDao {

	@PersistenceContext
	private EntityManager manager;

	public Function getById(int id) {
		return manager.find(Function.class,id);
	}

	@Transactional
	public void merge(Function function) {
		this.manager.merge(function);
	}

	@Transactional
	public void remove(Function function) {
		this.manager.remove(this.manager.contains(function) ? function : manager.merge(function));
	}

	public List<Function> getList() {
		TypedQuery<Function> query = this.manager.createQuery("select f from Function f", Function.class);
		return query.getResultList();
	}

}
