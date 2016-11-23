package br.com.valmirjunior.gradbook.control.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.valmirjunior.gradbook.model.Role;
import br.com.valmirjunior.gradbook.model.User;
import br.com.valmirjunior.gradbook.model.dao.UserDao;
import br.com.valmirjunior.gradbook.util.FacesUtil;

@ManagedBean(name = "loginManagerBean")
@SessionScoped
public class LoginManagerBean implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 9025665130510344622L;

	@EJB
	private UserDao userDao;
	private User user;
	private String login, password;
	private final String PAGE_ADMIN = "/admin/index.xhtml", PAGE_USER = "/user/index.xhtml",
			PAGE_HOME = "/login.xhtml";

	@PostConstruct
	private void init() {
		user = new User();
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}	
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() {
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
			request.login(login, password);
			user = userDao.getByLogin(login);
			login="";
			password="";
			String page=(user.getRole()==Role.ADMIN)? PAGE_ADMIN:PAGE_USER;			
		    context.redirect(context.getRequestContextPath() + page);
		} catch (ServletException | IOException e) {
			FacesUtil.showErrorMessage("Login ou senhas inválidos");
		}
	}

	public String logout() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		try {
			request.logout();
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.invalidate();
			return PAGE_HOME;
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void homeALlowedForRole() {
		ExternalContext context= FacesContext.getCurrentInstance().getExternalContext();
		String page=(user.getRole()==Role.ADMIN)? PAGE_ADMIN:PAGE_USER;			
		try {
			context.redirect(context.getRequestContextPath() + page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}