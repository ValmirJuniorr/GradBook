package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.valmirjunior.gradbook.model.Course;
import br.com.valmirjunior.gradbook.model.Semester;

@Stateless(name = "SemesterDao")
public class SemesterDao {

	@PersistenceContext
	private EntityManager manager;

	public Semester getById(int id) {
		return manager.find(Semester.class, id);
	}

	@Transactional
	public void merge(Semester semester) {
		this.manager.merge(semester);
	}

	@Transactional
	public void remove(Semester semester) {
		this.manager.remove(this.manager.contains(semester) ? semester : manager.merge(semester));
	}

	public List<Semester> getList() {
		TypedQuery<Semester> query = this.manager.createQuery("select s from Semester s", Semester.class);
		return query.getResultList();
	}

	public List<Semester> getListByCourse(Course course) {
		TypedQuery<Semester> query = this.manager.createQuery("select s from Semester s where s.course = :course",
				Semester.class);
		query.setParameter("course", course);
		return query.getResultList();
	}

}
