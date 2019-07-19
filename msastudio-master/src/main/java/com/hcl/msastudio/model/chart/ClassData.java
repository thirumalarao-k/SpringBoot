package com.hcl.msastudio.model.chart;

import java.util.ArrayList;

public class ClassData {
	private String name;
	private ArrayList<MethodData> children;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<MethodData> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<MethodData> children) {
		this.children = children;
	}
}
