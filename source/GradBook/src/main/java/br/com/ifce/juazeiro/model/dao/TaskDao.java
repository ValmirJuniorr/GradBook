package br.com.ifce.juazeiro.model.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.ifce.juazeiro.model.Task;

@Stateless(name="TaskDao")
public class TaskDao {

	@PersistenceContext
	private EntityManager manager;

	public Task getById(int id) {
		return manager.find(Task.class, id);
	}

	@Transactional
	public void merge(Task task) {
		this.manager.merge(task);
	}

	@Transactional
	public void remove(Task task) {
		this.manager.remove(this.manager.contains(task) ? task : manager.merge(task));
	}

	public List<Task> getList() {
		TypedQuery<Task> query = this.manager.createQuery("select t from Task t", Task.class);
		return query.getResultList();
	}

}
