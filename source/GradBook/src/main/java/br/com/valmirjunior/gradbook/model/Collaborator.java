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
@Table(schema = Consts.SCHEMA, name = Consts.TABLE_COLLABORATOR, uniqueConstraints = {
		@UniqueConstraint(name = Consts.UNIQUE_CONSTRAINT_COLLABORATOR, columnNames = { Consts.COLUMN_CPF_COLLABORATOR }) })
@SequenceGenerator(schema = Consts.SCHEMA, name = Consts.SEQUENCE_COLLABORATOR, sequenceName = Consts.SEQUENCE_NAME_COLLABORATOR, allocationSize = Consts.ALLOCATION_SIZE)
public class Collaborator implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7580940040892540212L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=Consts.SEQUENCE_COLLABORATOR)
	@Column(name=Consts.COLUMN_ID_COLLABORATOR)
	private int id;
	
	@NotNull
	@Size(max=Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name=Consts.COLUMN_NAME_COLLABORATOR)
	private String name;
	
	@NotNull
	@Size(max=Consts.SIZE_CPF,min=Consts.SIZE_CPF)
	@Column(name=Consts.COLUMN_CPF_COLLABORATOR)
	private String cpf;
	
	@OneToMany(mappedBy =Consts.COLLABORATOR,cascade = CascadeType.REMOVE)
	private List<Task> tasks;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Collaborator other = (Collaborator) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
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
		return "Collaborator [id=" + id + ", name=" + name + ", cpf=" + cpf + "]";
	}
	
}