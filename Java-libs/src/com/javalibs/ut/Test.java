package com.javalibs.ut;

import com.javalibs.math.NumberUtils;

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
}
