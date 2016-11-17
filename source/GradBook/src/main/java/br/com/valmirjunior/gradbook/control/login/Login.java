package br.com.valmirjunior.gradbook.control.login;

import java.io.IOException;
import java.security.Principal;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.valmirjunior.gradbook.model.Role;
import br.com.valmirjunior.gradbook.model.User;
import br.com.valmirjunior.gradbook.model.dao.UserDao;

@WebServlet(name = "index", urlPatterns = "/index")
public class Login extends HttpServlet {

	@Inject
	Principal principal;

	UserDao userDao;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3064868763286694433L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			userDao = (UserDao) new InitialContext().lookup("java:global/GradBook/UserDao");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		String login = principal.getName();
		User user = userDao.getByLogin(login);
		if (user.getRole() == Role.ADMIN) {
			response.sendRedirect(request.getContextPath() + "/admin/index.xhtml");
		} else {
			response.sendRedirect(request.getContextPath() + "/user/index.xhtml");
		}
	}

}
