package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Collaborator;

@Stateless(name = "CollaboratorDao")
public class CollaboratorDao extends GenericDao {
	
	public Collaborator getById(int id) {
		return super.getById(Collaborator.class, id);
	}

	public List<Collaborator> getList() {
		TypedQuery<Collaborator> query = super.manager.createQuery("select c from Collaborator c", Collaborator.class);
		return query.getResultList();
	}

}
