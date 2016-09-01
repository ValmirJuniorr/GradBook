package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Discipline;

@Stateless(name = "DisciplineDao")
public class DisciplineDao extends GenericDao{
	
	public Discipline getById(int id) {
		return super.getById(Discipline.class, id);
	}	

	public List<Discipline> getList() {
		TypedQuery<Discipline> query = super.manager.createQuery("select d from Discipline d ", Discipline.class);
		return query.getResultList();
	}

}
