package com.jsp.entity;

import java.util.Arrays;

public class Car {
	private int id;
	private String name;
	private String[] colors;

	public Car(int id, String name, String[] colors) {
		super();
		this.id = id;
		this.name = name;
		this.colors = colors;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", colors=" + Arrays.toString(colors) + "]";
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

	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

}
