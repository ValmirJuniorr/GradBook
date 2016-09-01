package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Function;

@Stateless(name = "FunctionDao")
public class FunctionDao extends GenericDao {

	public Function getById(int id) {
		return super.getById(Function.class, id);
	}

	public List<Function> getList() {
		TypedQuery<Function> query = super.manager.createQuery("select f from Function f", Function.class);
		return query.getResultList();
	}

}
