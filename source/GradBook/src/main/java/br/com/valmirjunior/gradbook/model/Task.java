package br.com.valmirjunior.gradbook.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema=Consts.SCHEMA,name=Consts.TABLE_TASK)
@SequenceGenerator(schema=Consts.SCHEMA, name=Consts.SEQUENCE_TASK,sequenceName=Consts.SEQUENCE_NAME_TASK, allocationSize=Consts.ALLOCATION_SIZE)
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5634765572185644812L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator=Consts.SEQUENCE_TASK)
	@Column(name=Consts.COLUMN_ID_TASK)
	private int id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name=Consts.COLUMN_DATE_STARTER_TASK)	
	private Date dateStarter;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name=Consts.COLUMN_DATE_END_TASK)
	private Date dateEnd;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = Consts.COLUMN_FUNCTION_TASK, foreignKey = @ForeignKey(name = Consts.FK_ID_FUNCTION_TASK))
	private Function function;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = Consts.COLUMN_COLLABORATOR_TASK, foreignKey = @ForeignKey(name = Consts.FK_ID_COLLABORATOR_TASK))
	private Collaborator collaborator;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = Consts.COLUMN_DISCIPLINE_TASK, foreignKey = @ForeignKey(name = Consts.FK_ID_DISCIPLINE_TASK))
	private Discipline discipline;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateStarter() {
		return dateStarter;
	}

	public void setDateStarter(Date dateStarter) {
		this.dateStarter = dateStarter;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Collaborator getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collaborator == null) ? 0 : collaborator.hashCode());
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStarter == null) ? 0 : dateStarter.hashCode());
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + ((function == null) ? 0 : function.hashCode());
		result = prime * result + id;
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
		Task other = (Task) obj;
		if (collaborator == null) {
			if (other.collaborator != null)
				return false;
		} else if (!collaborator.equals(other.collaborator))
			return false;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStarter == null) {
			if (other.dateStarter != null)
				return false;
		} else if (!dateStarter.equals(other.dateStarter))
			return false;
		if (discipline == null) {
			if (other.discipline != null)
				return false;
		} else if (!discipline.equals(other.discipline))
			return false;
		if (function == null) {
			if (other.function != null)
				return false;
		} else if (!function.equals(other.function))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", dateStarter=" + dateStarter + ", dateEnd=" + dateEnd + ", fuction=" + function
				+ ", collaborator=" + collaborator + ", discipline=" + discipline + "]";
	}
	
	
	

}
