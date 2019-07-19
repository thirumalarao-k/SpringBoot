package com.ktr.sb.pojos;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("students")
public class Student {
	
	@PrimaryKey
	private String studNumber;
	private String studName;
	private String studGroup;
	private String studPercentage;
	
	public String getStudNumber() {
		return studNumber;
	}
	public void setStudNumber(String studNumber) {
		this.studNumber = studNumber;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudGroup() {
		return studGroup;
	}
	public void setStudGroup(String studGroup) {
		this.studGroup = studGroup;
	}
	public String getStudPercentage() {
		return studPercentage;
	}
	public void setStudPercentage(String studPercentage) {
		this.studPercentage = studPercentage;
	}
	
	
}
