package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.valmirjunior.gradbook.model.Pole;

@Stateless(name="PoleDao")
public class PoleDao {

	@PersistenceContext
	private EntityManager manager;

	public Pole getById(int id) {
		return manager.find(Pole.class, id);
	}

	@Transactional
	public void merge(Pole pole) {
		this.manager.merge(pole);
	}

	@Transactional
	public void remove(Pole pole) {
		this.manager.remove(this.manager.contains(pole) ? pole : manager.merge(pole));
	}

	public List<Pole> getList() {
		TypedQuery<Pole> query = this.manager.createQuery("select p from Pole p", Pole.class);
		return query.getResultList();
	}
}
