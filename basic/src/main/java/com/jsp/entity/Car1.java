package com.jsp.entity;

import java.util.List;

public class Car1 {
	private int id;
	private String name;
	private List<String> colors;

	public Car1(int id, String name, List<String> colors) {
		super();
		this.id = id;
		this.name = name;
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "Car1 [id=" + id + ", name=" + name + ", colors=" + colors + "]";
	}

	public Car1() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

}
