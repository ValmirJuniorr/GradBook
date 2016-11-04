package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Collaborator;
import br.com.valmirjunior.gradbook.model.User;

@Stateless(name = "UserDao")
public class UserDao extends GenericDao {
	
	public User getById(int id) {
		return super.getById(User.class, id);
	}

	public List<User> getList() {
		TypedQuery<User> query = super.manager.createQuery("select u from User u", User.class);
		return query.getResultList();
	}

}
