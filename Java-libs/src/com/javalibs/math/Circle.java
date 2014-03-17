package com.javalibs.math;

import java.util.Arrays;

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

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", center="
				+ Arrays.toString(center) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(center);
		result = prime * result + radius;
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
		Circle other = (Circle) obj;
		if (!Arrays.equals(center, other.center))
			return false;
		if (radius != other.radius)
			return false;
		return true;
	}
	
	
}

