package com.Tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.MinimalHTMLWriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

public class Tests {
	
	
    public int param;
    public static int sparam;
    int value2;
    WebDriver driver;
    
//    @Factory(dataProvider = "dataMethod")
    public Tests(int param, int value2) {
    		if (!(param==99)&& !(value2==99)) {
    			this.param = param;
    			sparam = this.param;
        		this.value2 = value2;
			}
    		
    }
// 
//    @DataProvider(name = "dp")
//    public static Object[][] dataMethod() {
//        return new Object[][] { { 2,3 }, { 10,11 } };
//    }
//    
//  @Test(priority=1, dataProvider="dp")
//  public void Test1(int a, int b) {
//	  System.out.println("Test1:"+param+value2);
//	  System.out.println("for test case1: a "+a);
//	  System.out.println("for test case1: b "+b);
//  }
//  
//  @Test(priority=2)
//  public void Test2() {
//	  System.out.println("Test2:"+param+value2);
//  }
//  
//  @Test(priority=3)
//  public void Test3() {
//	  System.out.println("Test3:"+param+value2);
//  }
//  
//  @Test(priority=4)
//  public void Test4() {
//	  System.out.println("Test4:"+param+value2);
//  }
  
    @Test(priority=7)
    public void Test7() {
    	System.out.println("Test7:"+param);
    }
  
  @Test(priority=6)
  public void launchBrowser() {
	  System.out.println("Launching browser for Test case: "+param);
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  driver = new ChromeDriver();
	  if (param==1) {
		driver.get("http://www.jetstar.com/au/en/home");
	}else {
		driver.get("https://www.facebook.com/");
	}
	  driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
  }
  
  @BeforeClass
  public void beforeclass() {
	System.out.println("Starting Test Case: "+param);

  }
  
  @AfterClass
  public void afterclass() {
	System.out.println("Stopping Test Case: "+param);
	driver.quit();

  }
  
  
//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
}
