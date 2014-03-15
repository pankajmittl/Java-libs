package com.javalibs.util;

public class NumberBaseUtil {

	/* 2 <= b < 10 */
	public int toDecimal(int n, int b)
	{
	   int result=0;
	   int multiplier=1;
	      
	   while(n>0)
	   {
	      result+=n%10*multiplier;
	      multiplier*=b;
	      n/=10;
	   }
	      
	   return result;
	}

	/* for any value of b */
	public String fromDecimal2(int n, int b)
	{
	   String chars="0123456789ABCDEFGHIJ";
	   String result="";
	      
	   while(n>0)
	   {
	      result=chars.charAt(n%b) + result;
	      n/=b;
	   }
	      
	   return result;
	}
	
}
