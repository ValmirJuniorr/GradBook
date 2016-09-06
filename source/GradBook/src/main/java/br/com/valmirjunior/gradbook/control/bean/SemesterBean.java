package br.com.valmirjunior.gradbook.control.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.valmirjunior.gradbook.model.Course;
import br.com.valmirjunior.gradbook.model.Semester;
import br.com.valmirjunior.gradbook.model.dao.SemesterDao;
import br.com.valmirjunior.gradbook.util.FacesUtil;

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
	private List<Semester> semesters;
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
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Semester> getSemesters() {
		if (this.semesters == null) {
			this.semesters = semesterDao.getList();
		}
		return semesters;
	}	
	
	public List<Semester> getSemestersEager() {
		if (this.semesters == null) {
			this.semesters = semesterDao.getListEager();
		}
		return semesters;
	}	

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}	

	public List<Semester> getSemestersByCourse() {		
		if(this.semesters==null){
			updateSemesters();
		}
		return this.semesters;
	}

	
	public void updateSemesters(){
		if(this.course!=null){
			this.semesters=this.semesterDao.getListByCourse(this.course);
		}else{
			this.semesters=null;
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
