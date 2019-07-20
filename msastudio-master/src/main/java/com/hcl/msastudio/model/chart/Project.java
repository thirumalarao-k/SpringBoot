package com.hcl.msastudio.model.chart;

import java.util.ArrayList;

public class Project {
	private String name;
	private ArrayList<ClassData> children;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<ClassData> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<ClassData> children) {
		this.children = children;
	}
}
