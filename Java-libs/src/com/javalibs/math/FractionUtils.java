package com.javalibs.math;

import com.javalibs.math.NumberUtils;

public class FractionUtils {

	public static int[] reduceFraction(int a[])
	{
		int factor = NumberUtils.gcd(a[0], a[1]);
		int c[] = {a[0]/factor, a[1]/factor};
		return c;
	}
	
	public static int[] addFractions(int a[], int b[])
	{
		int denom = NumberUtils.lcm(a[1], b[1]);
		int c[] = {(denom/a[1])*a[0] + (denom/b[1])*b[0], denom};
		return c;
	}
	
	public static int[] subFractions(int a[], int b[])
	{
		int denom = NumberUtils.lcm(a[1], b[1]);
		int c[] = {(denom/a[1])*a[0] - (denom/b[1])*b[0], denom};
		return c;
	}
	
	public static int[] multiplyFractions(int a[], int b[])
	{
		a = reduceFraction(a);
		b = reduceFraction(b);
		
		int gcdf = NumberUtils.gcd(a[0]*b[0], a[1]*b[1]);
		int c[] = {a[0]*b[0]/gcdf, a[1]*b[1]/gcdf};
		
		return c;
	}
	
	public static int[] divFractions(int a[], int b[])
	{		
		int c[] = {b[1], b[0]};		
		return multiplyFractions(a, c);
	}

}
