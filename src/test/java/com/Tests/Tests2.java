package com.Tests;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Tests2 {
	String testCaseName = null;
	boolean isTest1Passed = false;
	boolean isTest2Passed = false;
	boolean isTest3Passed = false;
	boolean isTest4Passed = false;
	boolean isTest5Passed = false;

	@Test(priority = 10)
	public void Test1() {
		testCaseName = "Test1";
		System.out.println("+++++++++Running Test1++++++++++++");

	}

	@Test(priority = 20)
	public void Test2() {
		testCaseName = "Test2";
		System.out.println("+++++++++Running Test2++++++++++++");

	}

	@Test(priority = 30)
	public void Test3() {
		testCaseName = "Test3";
		System.out.println("+++++++++Running Test3++++++++++++");
//		throw new SkipException("Skipping the test");
	}

	@Test(priority = 40)
	public void Test4() {
		testCaseName = "Test4";
		System.out.println("+++++++++Running Test4++++++++++++");
		
	}

	@Test(priority = 50)
	public void Test5() {
		if (!(isTest3Passed||isTest4Passed)) {
			throw new SkipException("Skipping the test5");
		}
		testCaseName = "Test5";
		System.out.println("+++++++++Running Test5++++++++++++");

	}

	@AfterMethod
	private void afterMethod(ITestResult results) {
		if (testCaseName.equalsIgnoreCase("Test1") && results.isSuccess()) {
			isTest1Passed = true;
		} 
	}
}
