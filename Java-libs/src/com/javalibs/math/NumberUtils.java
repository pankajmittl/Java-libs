package com.javalibs.math;

import java.util.Arrays;

public class NumberUtils {

	public static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	public static int lcm(int a, int b) {
		if(a == 0 && b == 0) return 0;
		return (a * b)/gcd(a,b);
	}
	
	public static boolean isPrime (int n)
	{
	   if (n<2) return false;
	   if (n==2) return true;
	   if (n%2==0) return false;
	   int m=(int) Math.sqrt(n);

	   for (int i=3; i<=m; i+=2)
	      if (n%i==0)
	         return false;

	   return true;
	}

	public static boolean[] getPrimesInRange(int n)
	{
	   boolean[] prime=new boolean[n+1];
	   Arrays.fill(prime,true);
	   prime[0]=false;
	   prime[1]=false;
	   int m=(int) Math.sqrt(n);

	   for (int i=2; i<=m; i++)
	      if (prime[i])
	         for (int k=i*i; k<=n; k+=i)
	            prime[k]=false;

	   return prime;
	}
	
}
