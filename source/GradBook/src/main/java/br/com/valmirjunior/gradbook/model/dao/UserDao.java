package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.User;

@Stateless(name = "UserDao")
public class UserDao extends GenericDao {
	
	public User getById(int id) {
		return super.getById(User.class, id);
	}
	
	public User getByLogin(String login) {
		TypedQuery<User> query = super.manager.createQuery("select u from User u where Login_User = :login ", User.class);
		query.setParameter("login", login);
		List<User> users=query.getResultList();
		if(users.isEmpty()){
			return null;
		}else if(users.size()>1){
			return null;
		}else{
			return users.get(0);
		}
	}

	public List<User> getList() {
		TypedQuery<User> query = super.manager.createQuery("select u from User u", User.class);
		return query.getResultList();
	}

}
