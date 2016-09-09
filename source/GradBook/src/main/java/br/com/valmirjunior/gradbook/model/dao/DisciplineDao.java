package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Discipline;
import br.com.valmirjunior.gradbook.model.Semester;

@Stateless(name = "DisciplineDao")
public class DisciplineDao extends GenericDao {

	public Discipline getById(int id) {
		return super.getById(Discipline.class, id);
	}

	public List<Discipline> getList() {
		TypedQuery<Discipline> query = super.manager.createQuery("select d from Discipline d ", Discipline.class);
		return query.getResultList();
	}

	public List<Discipline> getListEager() {
		TypedQuery<Discipline> query = super.manager.createQuery(
				"select d from Discipline d left join fetch d.semester s left join fetch s.course", Discipline.class);
		return query.getResultList();
	}

	public List<Discipline> getListBySemester(Semester semester) {
		TypedQuery<Discipline> query = super.manager.createQuery("select d from Discipline d where d.semester = :semester", Discipline.class);
		query.setParameter("semester", semester);
		return query.getResultList();
	}

}
