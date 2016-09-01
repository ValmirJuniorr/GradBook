package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Team;

@Stateless(name = "TeamDao")
public class TeamDao extends GenericDao {

	@PersistenceContext
	private EntityManager manager;

	public Team getById(int id) {
		return super.getById(Team.class, id);
	}

	public List<Team> getList() {
		TypedQuery<Team> query = super.manager.createQuery("select t from Team t", Team.class);
		return query.getResultList();
	}

}
