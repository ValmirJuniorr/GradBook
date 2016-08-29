package br.com.ifce.juazeiro.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ifce.juazeiro.model.Task;
import br.com.ifce.juazeiro.model.dao.TaskDao;
import br.com.ifce.juazeiro.util.FacesUtil;

@ManagedBean(name = "taskBean")
@ViewScoped
public class TaskBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8481631874867843826L;
	
	@EJB
	private TaskDao taskDao;
	private Task task;
	private List<Task> tasks;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> getTasks() {
		if (this.tasks == null) {
			this.tasks = this.taskDao.getList();
		}
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void create() {
		this.taskDao.merge(this.task);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.taskDao.merge(this.task);
		this.setTasks(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Task task) {
		this.taskDao.remove(task);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setTask(new Task());
		this.setTasks(null);
	}

}
