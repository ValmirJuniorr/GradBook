package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Course;

@Stateless(name = "CourseDao")
public class CourseDao extends GenericDao{

	public Course getById(int id) {
		return super.getById(Course.class, id);
	}

	public List<Course> getList() {
		TypedQuery<Course> query = super.manager.createQuery("select c from Course c", Course.class);
		return query.getResultList();
	}

}
