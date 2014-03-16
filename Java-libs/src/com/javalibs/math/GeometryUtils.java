package com.javalibs.math;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;

public class GeometryUtils {
	
	/* 
	 * Based on Pick's theorem 
	 * Area = B/2 + I - 1 where
	 * B = number of lattice points on the boundary of the polygon
	 * I = number of lattice points in the interior of the polygon
	 * */
	final public int getAreaOfPolygonFromLatticePoints(int B, int I) {
		return B/2 + I -1;
	}
	
	int getInternalLatticePointCount(Dimension[] d, int edges) {
		return 0;
	}
	
	int getBoundaryLatticePointCount(Dimension[] d, int edges) {
		return 0;
	}
	
	public int getAreaOfPolygon(Dimension[] d, int edges) {
		int B = getBoundaryLatticePointCount(d, edges);
		int I = getInternalLatticePointCount(d, edges);
		return getAreaOfPolygonFromLatticePoints(B, I);
	}
		
	
	public int getAreaOfTriangle(Dimension[] d) {
		return getAreaOfPolygon(d, 3);
	}

	public int getAreaOfRectangle(Dimension[] d) {
		return getAreaOfPolygon(d, 3);
	}
	
	/*
	 * Input format is Ax + By = C
	 */
	public double[] getIntersectionPoint(int[] l1, int[] l2) {
		double[] cross = new double[2];

		double det = l1[0]*l2[1] - l2[0]*l1[1];
		if(det == 0){
			//Lines are parallel
			return null;
		}else{
			cross[0] = (l2[1]*l1[2] - l1[1]*l2[2])/det;
			cross[1] = (l1[0]*l2[2] - l2[0]*l1[2])/det;
		}
		return cross;
	}
}
