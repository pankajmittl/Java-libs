package com.javalibs.ut;

import java.util.Arrays;

import com.javalibs.math.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting Tests...");
		Test test = new Test();
		System.out.println("GCD Tests Passed :"+test.testGCD());
		System.out.println("LCM Tests Passed :"+test.testLCM());
		System.out.println("Geometry Tests Passed :"+test.testGeometry());
		
		new LinkListTest().runTests();
	}
	
	public boolean testGCD() {
		if(NumberUtils.gcd(2,0) != 2) return false;
		if(NumberUtils.gcd(0,0) != 0) return false;
		if(NumberUtils.gcd(12,2) != 2) return false;
		if(NumberUtils.gcd(12,8) != 4) return false;
		if(NumberUtils.gcd(100,9) != 1) return false;
		if(NumberUtils.gcd(32,16) != 16) return false;
		if(NumberUtils.gcd(16,32) != 16) return false;	//order test
		if(NumberUtils.gcd(8,12) != 4) return false;	//order test
		
		return true;
	}

	public boolean testLCM() {
		if(NumberUtils.lcm(2,0) != 0) return false;
		if(NumberUtils.lcm(0,0) != 0) return false;
		if(NumberUtils.lcm(12,2) != 12) return false;
		if(NumberUtils.lcm(12,8) != 24) return false;
		if(NumberUtils.lcm(100,9) != 900) return false;
		if(NumberUtils.lcm(32,16) != 32) return false;
		
		return true;
	}
	
	public boolean testGeometry() {
		
		//Test Case 1
		int a[] = {0, 0};
		int b[] = {2, 0};
		int[] pbs = GeometryUtils.getPerpendicularBisector(a, b);		
		if(pbs[0] != 1 || pbs[1] != 0 || pbs[2] != 1) return false;
		
		//Test Case 2
		a[0] = 6; a[1] = 0;
		b[0] = 0; b[1] = 4;
		pbs = GeometryUtils.getPerpendicularBisector(a, b);
		if(pbs[0] != 3 || pbs[1] != -2 || pbs[2] != 5) return false;
		
		//circle using 3 points test
		a[0] = 0; a[1] = 2;
		b[0] = 0; b[1] = -2;
		int[] c = {2, 0};
		Circle circle = GeometryUtils.getCircleFromThreePoints(a, b, c);
		
		a[0] = 0; a[1] = 0;
		if(!circle.equals(new Circle(2, a))) return false;
	
		//reflection point test -> y=0 & (2, 2)
		int[] line = {0, 1, 0};
		a[0] = -2; a[1] = -2;
		b = GeometryUtils.getReflectionPoint(a, line);
		//System.out.println(Arrays.toString(b));
		if(b[0] != -2 || b[1] != 2) return false;
		
		//reflection point test -> y=0 & (2, 2)
		line[0] = 1; line[1] = 1; line[2] = 32;
		a[0] = 0; a[1] = 0;
		b = GeometryUtils.getReflectionPoint(a, line);
		//System.out.println(Arrays.toString(b));
		if(b[0] != 32 || b[1] != 32) return false;
		
		//point rotation test1
		a[0] = 0; a[1] = 0;	//ref point
		b[0] = 2; b[1] = 0; //to be rotated
		c = GeometryUtils.getRotatedPointWRTPoint(a, b, 90);
		//System.out.println(Arrays.toString(c));
		if(c[0] != 0 || c[1] != 2) return false;

		//point rotation test2
		a[0] = 1; a[1] = 1;	//ref point
		b[0] = 2; b[1] = 2; //to be rotated
		c = GeometryUtils.getRotatedPointWRTPoint(a, b, 30);
		//System.out.println(Arrays.toString(c));
		//if(c[0] != 0 || c[1] != 2) return false;
		
		//convex hull test1
		int[][] points = {{1,1}, {2,2}, {2,5}, {4,2}};
		boolean boundary[] = GeometryUtils.getConvexHull(points);
		
		if(!boundary[0] || boundary[1] || !boundary[2] || !boundary[3]) return false;

		//convex hull test1
		int[][] points2 = {{2,2}, {2,4}, {3, 4}, {2,6}, {4,4}, {4,2}, {6, 6}};
		boundary = GeometryUtils.getConvexHull(points2);

		if(!boundary[0] || boundary[1] || boundary[2] || !boundary[3] ||
			boundary[4] || !boundary[5] || !boundary[6]) return false;
		
		//line point distance test
		double dist = VectorUtils.linePointDist(new int[]{0,0}, new int[]{0,4}, new int[]{0,2}, true);
		if(dist != 0) return false;
		
		//point in polygon test
		int[][] polygon = {{0,0}, {0,10}, {10,10}, {10,0}};
		
		a[0]=2; a[1]=2;
		b[0]=0; b[1]=2;
		System.out.println(GeometryUtils.pointInPolygon2(polygon, new int[]{5,5}));
		System.out.println(GeometryUtils.pointInPolygon2(polygon, new int[]{10,15}));
		System.out.println(GeometryUtils.pointInPolygon2(polygon, new int[]{5,10}));
		
		int[][] polygon2 = {{-100, -90}, {-100, 100},{100, 100}, {100, -100},
				{-120, -100},{-120, 100},{-130, 100},{-130, -110},
				{110, -110}, {110, 110}, {-110, 110},{-110, -90}};

		System.out.println(GeometryUtils.pointInPolygon2(polygon2, new int[]{0,0}));
		
		return true;
	}
}
