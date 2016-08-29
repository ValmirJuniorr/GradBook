package br.com.ifce.juazeiro.control.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.ifce.juazeiro.model.Course;
import br.com.ifce.juazeiro.model.dao.GenericDao;

@FacesConverter(forClass = Course.class)
public class CourseConverter implements Converter {
	
	private GenericDao genericDao;

	public CourseConverter() {
		try {
			this.genericDao = (GenericDao) new InitialContext().lookup("java:global/GradBook/GenericDao");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != "") {
			return genericDao.getById(Course.class, Integer.parseInt(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Course) value).getId() + "";
		}
		return null;
	}

}
