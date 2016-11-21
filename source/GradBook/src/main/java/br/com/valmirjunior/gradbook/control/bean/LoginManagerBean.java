package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.valmirjunior.gradbook.control.login.Login;
import br.com.valmirjunior.gradbook.model.User;

@ManagedBean(name = "loginManagerBean")
@SessionScoped
public class LoginManagerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9025665130510344622L;

	private User user;

	@PostConstruct
	private void init() {
		user=Login.getUser();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
