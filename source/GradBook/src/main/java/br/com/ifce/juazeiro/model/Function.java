package br.com.ifce.juazeiro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(schema = Consts.SCHEMA, name = Consts.TABLE_FUNCTION, uniqueConstraints = {
		@UniqueConstraint(name = Consts.UNIQUE_CONSTRAINT_FUNCTION, columnNames = { Consts.COLUMN_NAME_FUNCTION }) })
@SequenceGenerator(schema = Consts.SCHEMA, name = Consts.SEQUENCE_FUNCTION, sequenceName=Consts.SEQUENCE_NAME_FUNCTION, allocationSize=Consts.ALLOCATION_SIZE)
public class Function implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -263251088736271704L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Consts.SEQUENCE_FUNCTION)	
	@Column(name = Consts.COLUMN_ID_FUNCTION)
	private int id;

	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_NAME_FUNCTION)
	private String name;

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
		Function other = (Function) obj;
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
		return "Fuction [id=" + id + ", name=" + name + "]";
	}

}
