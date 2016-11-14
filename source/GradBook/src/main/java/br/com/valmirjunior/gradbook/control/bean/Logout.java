package br.com.valmirjunior.gradbook.control.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="logout")
@SessionScoped
public class Logout {
	public String efetuarLogout(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		System.out.println("logout success");
		return "/login.xhtml";
	}
}