package com.javalibs.math;

public class Circle {

	int radius;
	int[] center;
	
	public Circle() {
		super();
	}
	
	public Circle(int radius, int[] center) {
		super();
		this.radius = radius;
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int[] getCenter() {
		return center;
	}
	public void setCenter(int[] center) {
		this.center = center;
	}
}

