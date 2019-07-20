package com.hcl.msa.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
//@Table(name="TECHNOLOGY_INFO")
//@Immutable
@Subselect("select * from TECHNOLOGY_INFO")
public class TechnologyInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "technology",length=100)
	private String technology;
	
	@Column(name = "parser",length=100)
	private String parser;
	
	@OneToMany
	@JoinColumn(name = "technology_id")
	private Set<ProjectSetting> projSet;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getParser() {
		return parser;
	}

	public void setParser(String parser) {
		this.parser = parser;
	}
	
	@Override
	public String toString() {
		return "SourceCodeCatalog [id=" + id + ", technology=" + technology + ", parser=" + parser + "]";
	}

} 