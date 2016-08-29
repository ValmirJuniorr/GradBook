package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Course;

@Stateless(name = "CourseDao")
public class CourseDao {

	@PersistenceContext
	private EntityManager manager;

	public Course getById(int id) {
		return this.manager.find(Course.class, id);
	}

	public void merge(Course course) {
		this.manager.merge(course);
	}

	public void remove(Course course) {
		this.manager.remove(this.manager.contains(course) ? course : manager.merge(course));
	}

	public List<Course> getList() {
		TypedQuery<Course> query = this.manager.createQuery("select c from Course c", Course.class);
		return query.getResultList();
	}

}
