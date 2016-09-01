package br.com.valmirjunior.gradbook.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.valmirjunior.gradbook.model.Task;

@Stateless(name = "TaskDao")
public class TaskDao extends GenericDao {
	public Task getById(int id) {
		return super.getById(Task.class, id);
	}

	public List<Task> getList() {
		TypedQuery<Task> query = super.manager.createQuery("select t from Task t", Task.class);
		return query.getResultList();
	}

}
