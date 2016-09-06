package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Course;
import br.com.valmirjunior.gradbook.model.Semester;

@Stateless(name = "SemesterDao")
public class SemesterDao extends GenericDao {

	public Semester getById(int id) {
		return manager.find(Semester.class, id);
	}

	public List<Semester> getList() {
		TypedQuery<Semester> query = super.manager.createQuery("select s from Semester s order by s.name", Semester.class);
		return query.getResultList();
	}
	
	public List<Semester> getListEager() {
		TypedQuery<Semester> query = super.manager.createQuery("select s from Semester s  left join  fetch s.course", Semester.class);
		return query.getResultList();
	}

	public List<Semester> getListByCourse(Course course) {
		TypedQuery<Semester> query = super.manager.createQuery("select s from Semester s where s.course = :course",
				Semester.class);
		query.setParameter("course", course);
		return query.getResultList();
	}

}
