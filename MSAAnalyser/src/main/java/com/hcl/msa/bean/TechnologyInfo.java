package com.hcl.msa.bean;

public class TechnologyInfo{

	private int id;
	private String technology;
	private String parser;
	
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