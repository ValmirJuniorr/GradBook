package br.com.valmirjunior.gradbook.model;

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

@Entity
@Table(schema=Consts.SCHEMA, name=Consts.TABLE_ROLE,uniqueConstraints={
		@UniqueConstraint(name=Consts.UNIQUE_CONSTRAINT_ROLE,columnNames={Consts.COLUMN_NAME_ROLE})
})
@SequenceGenerator(schema=Consts.SCHEMA,name=Consts.SEQUENCE_ROLE,sequenceName=Consts.SEQUENCE_NAME_ROLE, allocationSize=Consts.ALLOCATION_SIZE )
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=Consts.SEQUENCE_ROLE)
	@Column(name=Consts.COLUMN_ID_ROLE)
	private int id;
	
	@NotNull
	@Size(max = Consts.MAX_SIZE_NORMAL_TEXT)
	@Column(name = Consts.COLUMN_NAME_ROLE)
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

	
	
	
	
}
