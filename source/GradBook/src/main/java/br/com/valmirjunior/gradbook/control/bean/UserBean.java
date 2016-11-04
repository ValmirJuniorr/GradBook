package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.valmirjunior.gradbook.model.User;
import br.com.valmirjunior.gradbook.model.dao.UserDao;
import br.com.valmirjunior.gradbook.util.FacesUtil;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -262721000492360781L;
	
	
	@EJB
	private UserDao userDao;
	private User user;
	private List<User> users;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void create() {
		this.userDao.merge(this.user);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.userDao.merge(this.user);
		this.setUsers(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(User user) {
		this.userDao.remove(user);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setUser(new User());
		this.setUsers(null);
	}

}
