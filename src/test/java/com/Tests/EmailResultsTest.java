package com.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Emailer.Emailer;

public class EmailResultsTest {

	protected static String workingDir = System.getProperty("user.dir").replace("\\", "/");

	@Test
	public void sendEmail() throws Exception {
		Emailer.execute("index.html", workingDir + "/target/surefire-reports/html");
	}

	@AfterClass
	public static void teardown() throws Exception {

		System.out.println("Email sent with test results");
	}

}