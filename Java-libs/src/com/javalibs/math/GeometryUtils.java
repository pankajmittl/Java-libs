package com.javalibs.math;

public class GeometryUtils {
	
	/* 
	 * Based on Pick's theorem 
	 * Area = B/2 + I - 1 where
	 * B = number of lattice points on the boundary of the polygon
	 * I = number of lattice points in the interior of the polygon
	 * */
	final static public int getAreaOfPolygonFromLatticePoints(int B, int I) {
		return B/2 + I -1;
	}
	
	static int getInternalLatticePointCount(int[][] d, int edges) {
		return 0;
	}
	
	static int getBoundaryLatticePointCount(int[][] d, int edges) {
		return 0;
	}
	
	public static int getAreaOfPolygon(int[][] d, int edges) {
		int B = getBoundaryLatticePointCount(d, edges);
		int I = getInternalLatticePointCount(d, edges);
		return getAreaOfPolygonFromLatticePoints(B, I);
	}
		
	
	public static int getAreaOfTriangle(int[][] d) {
		return getAreaOfPolygon(d, 3);
	}

	public static int getAreaOfRectangle(int[][] d) {
		return getAreaOfPolygon(d, 3);
	}
	
	public static double getDistanceBwTwoPoints(int[] a, int[] b)
	{
		return Math.sqrt((a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]));
	}
	
	/*
	 * Input format is Ax + By = C
	 */
	public static double[] getIntersectionPoint(int[] l1, int[] l2) {
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
	
	public static int[] normalizeLine(int[] line) {
		int gcdf = NumberUtils.gcd(NumberUtils.gcd(line[0], line[1]), line[2]);

		if(gcdf > 1) {
			line[0] /= gcdf;
			line[1] /= gcdf;
			line[2] /= gcdf;
		}

		int negCount = 0;
		int zeroCount = 0;
		if(line[0] < 0) negCount++;
		if(line[1] < 0) negCount++;
		if(line[2] < 0) negCount++;

		if(line[0] < 0) zeroCount++;
		if(line[1] < 0) zeroCount++;
		if(line[2] < 0) zeroCount++;


		if(negCount > 1 || (negCount == 1 && zeroCount == 2)){
			line[0] *= -1;
			line[1] *= -1;
			line[2] *= -1;
		}
		return line;
	}

	public static int[] getLineWithSlopeAndPoint(int [] slope, int[] point)
	{
		int [] line = new int[3];
		
		line[0] = slope[0];
		line[1] = -1 * slope[1];
		line[2] = point[0] * slope[0] - point[1] * slope[1];
		
		return normalizeLine(line);
	}
	
	public static int[] getSlope(int a[], int b[])
	{
		int[] slope = {b[1] - a[1], b[0] - a[0]};
		
		if(slope[0] < 0 && slope[1] < 0) {
			slope[0] *= -1;
			slope[1] *= -1;
		}
		
		return FractionUtils.reduceFraction(slope);
	}
	
	/*
	 * Line format will be Ax + By = C
	 * @return Line 
	 */
	public static int[] getPerpendicularBisector(int a[], int b[]) {
		int[] bisector = new int[2];
		
		bisector[0] = (a[0] + b[0])/2;
		bisector[1] = (a[1] + b[1])/2;
		
		int[] slope = getSlope(a, b);		
		int[] bslope = {-1 * slope[1], slope[0]};
		
		return getLineWithSlopeAndPoint(bslope, bisector);
	}
	
	public static Circle getCircleFromThreePoints(int a[], int b[], int c[])
	{
		int[] pbs1 = getPerpendicularBisector(a, b);
		int[] pbs2 = getPerpendicularBisector(b, c);
		
		double[] cross = getIntersectionPoint(pbs1, pbs2);
		int[] icross = {(int)cross[0], (int)cross[1]};
		
		Circle circle = new Circle();
		circle.setCenter(new int[]{(int)cross[0], (int)cross[1]});
		circle.setRadius((int)getDistanceBwTwoPoints(icross, a));
		
		return circle;
	}
	
}