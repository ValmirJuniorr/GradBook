package br.com.ifce.juazeiro.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ifce.juazeiro.model.Course;
import br.com.ifce.juazeiro.model.dao.CourseDao;
import br.com.ifce.juazeiro.util.FacesUtil;

@ManagedBean(name = "courseBean")
@ViewScoped
public class CourseBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1807628708916872297L;

	@EJB
	private CourseDao courseDao;
	private Course course;
	private List<Course> courses;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Course> getCourses() {
		if (this.courses == null) {
			this.courses = this.courseDao.getList();
		}
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void create() {
		this.courseDao.merge(this.course);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.courseDao.merge(this.course);
		this.setCourses(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Course course) {
		this.courseDao.remove(course);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setCourse(new Course());
		this.setCourses(null);
	}

}
