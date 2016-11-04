package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.valmirjunior.gradbook.model.User;

@ManagedBean(name = "loginManagerBean")
@ViewScoped
public class LoignManagerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9025665130510344622L;

//	@Resource(mappedName = "java:comp/EJBContext")
//	protected SessionContext sessionContext;

	private User user;

	@PostConstruct
	private void init() {
	}

	public User getUser() {
	
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void getUserLoged() {
//		Principal callerPrincipal = sessionContext.getCallerPrincipal();
//		return  callerPrincipal.toString();
	}

}
