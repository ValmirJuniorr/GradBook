package br.com.valmirjunior.gradbook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = Consts.SCHEMA, name = Consts.TABLE_DISCIPLINE)
@SequenceGenerator(schema = Consts.SCHEMA, name = Consts.SEQUENCE_DISCIPLINE, sequenceName = Consts.SEQUENCE_NAME_DISCIPLINE, allocationSize = Consts.ALLOCATION_SIZE)
public class Discipline implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9146896021126655456L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Consts.SEQUENCE_DISCIPLINE)
	@Column(name = Consts.COLUMN_ID_DISCIPLINE)
	private int id;	

	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_NAME_DISCIPLINE)
	private String name;
	
	@NotNull
	@Max(Consts.MAX_VALUE_WORK_LOAD)
	@Min(Consts.MIN_VALUE_WORK_LOAD)
	@Column(name = Consts.COLUMN_WORK_LOAD_DISCIPLINE)
	private int Work_Load;

	@NotNull
	@ManyToOne
	@JoinColumn(name = Consts.COLUMN_SEMESTER_DISCIPLINE, foreignKey = @ForeignKey(name = Consts.FK_ID_SEMESTER_DISCIPLINE))
	private Semester semester;

	
	
	
	public Discipline() {
		super();
		Work_Load = 20;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Semester getSemester() {
		return semester;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}	

	public int getWork_Load() {
		return Work_Load;
	}

	public void setWork_Load(int work_Load) {
		Work_Load = work_Load;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
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
		Discipline other = (Discipline) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Discipline [id=" + id + ", name=" + name + ", semester=" + semester + "]";
	}


	

}
