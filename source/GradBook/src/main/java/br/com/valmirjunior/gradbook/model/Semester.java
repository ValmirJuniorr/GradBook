package br.com.valmirjunior.gradbook.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = Consts.SCHEMA, name = Consts.TABLE_SEMESTER)
@SequenceGenerator(schema = Consts.SCHEMA, name = Consts.SEQUENCE_SEMESTER, sequenceName = Consts.SEQUENCE_NAME_SEMESTER, allocationSize = Consts.ALLOCATION_SIZE)
public class Semester implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -7461816001295621666L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Consts.SEQUENCE_SEMESTER)
	@Column(name = Consts.COLUMN_ID_SEMESTER)
	private int id;

	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_NAME_SEMESTER)
	private String name;

	@NotNull
	@ManyToOne	
	@JoinColumn(name = Consts.COLUMN_COURSE_SEMESTER, foreignKey = @ForeignKey(name = Consts.FK_ID_COURSE_SEMESTER))
	private Course course;


	
	@OneToMany(mappedBy =Consts.SEMESTER,cascade = CascadeType.REMOVE)
	private List<Discipline> disciplines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Semester other = (Semester) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Semester [id=" + id + ", name=" + name + ", course=" + course + "]";
	}

	
}
