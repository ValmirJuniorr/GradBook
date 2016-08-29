package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.valmirjunior.gradbook.model.Collaborator;

@Stateless(name="CollaboratorDao")
public class CollaboratorDao {

	@PersistenceContext
	private EntityManager manager;

	public Collaborator getById(int id) {
		return manager.find(Collaborator.class, id);
	}

	@Transactional
	public void merge(Collaborator collaborator) {
		this.manager.merge(collaborator);
	}

	@Transactional
	public void remove(Collaborator collaborator) {
		this.manager.remove(this.manager.contains(collaborator) ? collaborator : manager.merge(collaborator));
	}

	public List<Collaborator> getList() {
		TypedQuery<Collaborator> query = this.manager.createQuery("select c from Collaborator c", Collaborator.class);
		return query.getResultList();
	}

}
