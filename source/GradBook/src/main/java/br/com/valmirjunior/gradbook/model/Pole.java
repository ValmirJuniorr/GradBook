package br.com.valmirjunior.gradbook.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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

@Entity
@Table(schema=Consts.SCHEMA, name=Consts.TABLE_POLE, uniqueConstraints={
		@UniqueConstraint(name=Consts.UNIQUE_CONSTRAINT_POLE,columnNames={Consts.COLUMN_NAME_POLE})})
@SequenceGenerator(schema = Consts.SCHEMA,name=Consts.SEQUENCE_POLE, sequenceName=Consts.SEQUENCE_NAME_POLE, allocationSize=Consts.ALLOCATION_SIZE)
public class Pole implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5514708045810372043L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Consts.SEQUENCE_POLE)	
	@Column(name=Consts.COLUMN_ID_POLE)
	private int id;
	
	@NotNull
	@Size(max=Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name=Consts.COLUMN_NAME_POLE)
	private String name;
	
	@OneToMany(mappedBy = Consts.POLE,cascade=CascadeType.REMOVE)
	private List<Team> teams;
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
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
		Pole other = (Pole) obj;
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
		return "Pole [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
