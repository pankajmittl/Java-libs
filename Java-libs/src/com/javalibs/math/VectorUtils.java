package com.javalibs.math;

/*
 * Source topcoder.com
 */

public class VectorUtils {

	//Compute the dot product AB ⋅ AC
    public static int dot(int[] A, int[] B, int[] C){
        int[] AB = new int[2];
        int[] AC = new int[2];
        AB[0] = B[0]-A[0];
        AB[1] = B[1]-A[1];
        AC[0] = C[0]-A[0];
        AC[1] = C[1]-A[1];
        int dot = AB[0] * AC[0] + AB[1] * AC[1];
        return dot;
    }
    
    //Compute the cross product AB x AC
    int cross(int[] A, int[] B, int[] C){
        int[] AB = new int[2];
        int[] AC = new int[2];
        AB[0] = B[0]-A[0];
        AB[1] = B[1]-A[1];
        AC[0] = C[0]-A[0];
        AC[1] = C[1]-A[1];
        int cross = AB[0] * AC[1] - AB[1] * AC[0];
        return cross;
    }
    
    //Compute the distance from A to B
    double distance(int[] A, int[] B){
        int d1 = A[0] - B[0];
        int d2 = A[1] - B[1];
        return Math.sqrt(d1*d1+d2*d2);
    }
    
    //Compute the distance from AB to C
    //if isSegment is true, AB is a segment, not a line.
    double linePointDist(int[] A, int[] B, int[] C, boolean isSegment){
        double dist = cross(A,B,C) / distance(A,B);
        if(isSegment){
            int dot1 = dot(A,B,C);
            if(dot1 > 0)return distance(B,C);
            int dot2 = dot(B,A,C);
            if(dot2 > 0)return distance(A,C);
        }
        return Math.abs(dist);
    }
    
    public static int polygonArea(int[][] p)
    {
    	int area = 0;
    	int N = p.length;
    	int cross = 0;
    	//We will triangulate the polygon
    	//into triangles with points p[0],p[i],p[i+1]

    	for(int i = 1; i+1<N; i++){
    		int x1 = p[i][0] - p[0][0];
    		int y1 = p[i][1] - p[0][1];
    		int x2 = p[i+1][0] - p[0][0];
    		int y2 = p[i+1][1] - p[0][1];
    		cross = x1*y2 - x2*y1;
    		area += cross;
    	}
    	return Math.abs(cross/2);
    }
}
