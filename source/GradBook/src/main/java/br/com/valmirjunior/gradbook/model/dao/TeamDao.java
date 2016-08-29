package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.valmirjunior.gradbook.model.Team;

@Stateless(name="TeamDao")
public class TeamDao {

	@PersistenceContext
	private EntityManager manager;

	public Team getById(int id) {
		return manager.find(Team.class, id);
	}

	@Transactional
	public void merge(Team team) {
		this.manager.merge(team);
	}

	@Transactional
	public void remove(Team team) {
		this.manager.remove(this.manager.contains(team) ? team : manager.merge(team));
	}

	public List<Team> getList() {
		TypedQuery<Team> query = this.manager.createQuery("select t from Team t", Team.class);
		return query.getResultList();
	}

}
