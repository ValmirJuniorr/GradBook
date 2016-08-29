package br.com.ifce.juazeiro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Valmir
 *
 */
@Entity
@Table(schema = Consts.SCHEMA, name = Consts.TABLE_COURSE, uniqueConstraints = {
		@UniqueConstraint(name = Consts.UNIQUE_CONSTRAINT_COURSE, columnNames = { Consts.COLUMN_ABREVIATION_COURSE }) })
@SequenceGenerator(schema = Consts.SCHEMA, name = Consts.SEQUENCE_COURSE, sequenceName = Consts.SEQUENCE_NAME_COURSE, allocationSize = Consts.ALLOCATION_SIZE)
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2204827943910066357L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Consts.SEQUENCE_COURSE)
	@Column(name = Consts.COLUMN_ID_COURSE)
	private int id;

	@NotNull
	@Size(max = Consts.MAX_SIZE_SMALL_TEXT)
	@Column(name = Consts.COLUMN_ABREVIATION_COURSE)
	private String abbreviation;

	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_NAME_COURSE)
	private String name;

	@OneToMany(mappedBy = Consts.COURSE)
	private List<Semester> semesters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abbreviation == null) ? 0 : abbreviation.hashCode());
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
		Course other = (Course) obj;
		if (abbreviation == null) {
			if (other.abbreviation != null)
				return false;
		} else if (!abbreviation.equals(other.abbreviation))
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
		return "Course [id=" + id + ", abbreviation=" + abbreviation + ", name=" + name + "]";
	}

}
