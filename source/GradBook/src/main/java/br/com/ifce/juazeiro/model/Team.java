package br.com.ifce.juazeiro.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = Consts.SCHEMA, name = Consts.TABLE_TEAM)
@SequenceGenerator(schema = Consts.SCHEMA, name = Consts.SEQUENCE_TEAM, sequenceName = Consts.SEQUENCE_NAME_TEAM, allocationSize = Consts.ALLOCATION_SIZE)
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1785896541052568530L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Consts.SEQUENCE_TEAM)
	@Column(name = Consts.COLUMN_ID_TEAM)
	private int id;

	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_NAME_TEAM)
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = Consts.COLUMN_SEMESTER_TEAM, foreignKey = @ForeignKey(name = Consts.FK_ID_SEMESTER_TEAM))
	private Semester semester;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = Consts.COLUMN_POLE_TEAM, foreignKey = @ForeignKey(name = Consts.FK_ID_POLE_TEAM))
	private Pole pole;

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

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Pole getPole() {
		return pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Team other = (Team) obj;
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
		return "Team [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
