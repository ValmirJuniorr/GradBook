package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.valmirjunior.gradbook.model.Discipline;

@Stateless(name="DisciplineDao")
public class DisciplineDao {

	@PersistenceContext
	private EntityManager manager;

	public Discipline getById(int id) {
		return manager.find(Discipline.class,id);
	}

	
	@Transactional
	public void merge(Discipline discipline) {
		this.manager.merge(discipline);
	}

	@Transactional
	public void remove(Discipline discipline) {
		this.manager.remove(this.manager.contains(discipline) ? discipline : manager.merge(discipline));
	}

	public List<Discipline> getList() {
		TypedQuery<Discipline> query = this.manager.createQuery("select d from Discipline d", Discipline.class);
		return query.getResultList();
	}


	
	

}
