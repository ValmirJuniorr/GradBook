package br.com.valmirjunior.gradbook.control.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.valmirjunior.gradbook.model.Team;
import br.com.valmirjunior.gradbook.model.dao.GenericDao;

@FacesConverter(forClass = Team.class)
public class TeamConverter implements Converter {

	private GenericDao genericDao;

	public TeamConverter() {
		try {
			this.genericDao = (GenericDao) new InitialContext().lookup("java:global/GradBook/GenericDao");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != "") {
			return genericDao.getById(Team.class, Integer.parseInt(value));
			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Team) value).getId() + "";
		}
		return null;
	}

}
