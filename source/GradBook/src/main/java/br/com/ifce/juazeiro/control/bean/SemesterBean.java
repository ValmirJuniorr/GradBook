package br.com.ifce.juazeiro.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.ifce.juazeiro.model.Course;
import br.com.ifce.juazeiro.model.Semester;
import br.com.ifce.juazeiro.model.dao.SemesterDao;
import br.com.ifce.juazeiro.util.FacesUtil;

@ManagedBean(name = "semesterBean")
@ViewScoped
public class SemesterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7864227491233723210L;

	@EJB
	private SemesterDao semesterDao;
	private Semester semester;
	private List<Semester> semesters,semestersByCourse;
	private Course course;

	@PostConstruct
	private void init() {
		this.resetAttributes();
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Semester> getSemesters() {
		if (this.semesters == null) {
			this.semesters = semesterDao.getList();
		}
		return semesters;
	}	

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Semester> getSemestersByCourse() {		
		return this.semestersByCourse;
	}

	public void setSemestersByCourse(List<Semester> semestersByCourse) {
		this.semestersByCourse = semestersByCourse;
	}
	
	public void updateSemesters(){
		if(this.semestersByCourse==null){
			this.semestersByCourse=this.semesterDao.getListByCourse(this.course);
		}
	}

	public void create() {
		this.semesterDao.merge(this.semester);
		this.resetAttributes();
		FacesUtil.showCreateRegisterMessage();
	}

	public void update() {
		this.semesterDao.merge(this.semester);
		this.setSemesters(null);
		FacesUtil.showUpdateRegisterMessage();
	}

	public void delete(Semester semester) {
		this.semesterDao.remove(semester);
		this.resetAttributes();
		FacesUtil.showDeleteRegisterMessage();
	}

	private void resetAttributes() {
		this.setSemester(new Semester());
		this.setSemesters(null);
	}

}
