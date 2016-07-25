package com.BaseClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.URL;
import org.xml.sax.SAXException;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.picocontainer.PicoBuilder;
import java.net.URL;
import org.xml.sax.SAXException;
//import com.applitools.eyes.Eyes;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.MatchLevel;


public abstract class BaseClass {

	static WebDriver Driver = null;
	String ReturnText;
	static DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
	static Date date = new Date();
	static int count = 0;
	public static String newdate = dateFormat.format(date).toString();
	public static File scrshot;
	static String reportContent = "";
	public static final String USERNAME = "mickwingert2";
	public static final String AUTOMATE_KEY = "7qLhvqFfMX262y8VYfJ9";
//	public static final String BSURL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	//16/03/2016
	public static final String BSURL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-us.browserstack.com/wd/hub";
	//U: mick.wingert@isobar.com
	//P: Om3NF7uSvDm7
	public static String Key = "88Cat102X8cT1kbNlNx55DyKhGqlzpPvDNwjP2pTgJ6Mg110";
	public static int numberoflastrow;
	public static int lastcellnumber;
	public static String BaseURLFunctionalTests = System.getProperty("webdriver.fbase.url");
	public static String BaseURLsVisualTest = System.getProperty("webdriver.vbase.url");
	
	
	
	static Eyes eyes = new Eyes();

	public static String createDateFolder(String path) throws IOException {
		String FolderName = path + newdate;
		@SuppressWarnings("unused")
		boolean fireup = (new File(FolderName)).mkdirs();
		File Folder = new File(FolderName);
		count = Folder.list().length;
		String CurrentRun = FolderName + "\\Run#" + (count + 1) + "\\";
		@SuppressWarnings("unused")
		boolean fireup2 = (new File(CurrentRun)).mkdirs();
		System.out.println("Folder Created " + CurrentRun);
		return CurrentRun;
	}

	public static WebDriver BrowserSetup(String BrowserType) {
		if (BrowserType.contentEquals("firefox")) {
			Driver = new FirefoxDriver();
		} else if (BrowserType.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			Driver = new ChromeDriver();
		} else if (BrowserType.contentEquals("ie")) {
			Driver = new InternetExplorerDriver();
		}

		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return Driver;
	}
	
	public static WebDriver BrowserStackBrowserSetup(String BrowserType) throws InterruptedException, MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities(); 
		if (BrowserType.contentEquals("firefox")) {
            caps.setCapability("browser", "Firefox");
            caps.setCapability("browser_version", "31.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "8");
		} else if (BrowserType.contentEquals("chrome")) {
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "39.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "8");
		} else if (BrowserType.contentEquals("ie")) {
            caps.setCapability("browser", "IE");
            caps.setCapability("browser_version", "11.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "8.1");  
		}

        caps.setCapability("resolution", "1280x800");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("project", "Jetstar.com Redev Project");
        caps.setCapability("build", "TeamCityRun");
        Driver = new RemoteWebDriver(new java.net.URL(BSURL),caps);
        Driver.manage().window().maximize();
        Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Thread.sleep(5000);
        return Driver;
	}

	public static boolean GetURL(String URL) {

		Driver.get(URL);
		return true;

	}
	
	public static boolean linkExists(String URLName){
	    try {
	      HttpURLConnection.setFollowRedirects(false);
	      HttpURLConnection con =
	         (HttpURLConnection) new java.net.URL(URLName).openConnection();
	      con.setRequestMethod("HEAD");
	      return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	       return false;
	    }
	  }

	public boolean WaitFor4Seconds() throws InterruptedException {

		Thread.sleep(4000);
		return true;

	}

	public static void BrowserTeardown()

	{
		Driver.close();
		Driver.quit();
	}

	public boolean StartWaitingforElement(WebElement myElement)
			throws Exception {
		while (!myElement.isDisplayed())
			;
		{
			Thread.sleep(1000);
		}
		System.out.println("Found Element:" + myElement.getTagName());
		return true;

	}

	public boolean checkElementDisplayed(WebDriver driver, List<WebElement> ele)
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		boolean exists = ele.size() != 0;
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		if (exists == true) {
			return true;
		} else {
			return false;
		}
		
	}
	public boolean Click(WebElement myElement) {
		try {
			myElement.click();
			return true;
		} catch (Exception e) {
			if (!(myElement==null)) {
				System.out.println("Element in error is: "+myElement.getText());
			}
			return false;
		}
	}

	public boolean EnterText(WebElement myElement, String textToEnter) {
		myElement.clear();
		myElement.sendKeys(textToEnter);
		return true;
	}

	public boolean SelectDropDown(WebElement myElement, String Value) {
		Select mySelection = new Select(myElement);
		mySelection.selectByValue(Value);
		return true;
	}

	public boolean CheckTextPresent(WebElement myElement, String Text) {
		if (myElement.getText().contentEquals(Text)) {
			System.out.println("Text " + Text
					+ " present at specified element location");
			return true;
		} else {
			System.out.println("Text " + Text
					+ " not Present at specified element location");
			return false;
		}
	}

	public String GetTextPresent(WebElement myElement) {

		if (myElement.isDisplayed())

		{
			ReturnText = myElement.getText();
			return ReturnText;
		} else
			return "Unable to find Element";

	}

	public static void capturescreenshot(WebDriver driver, String filename) throws IOException, InterruptedException{
		Thread.sleep(1000);
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String os = cap.getPlatform().toString();
		String v = cap.getVersion().toString();
		File scrshot = Screenshot(driver);
//		FileUtils.copyFile(scrshot, new File(CommonMethods.foldername+"//"+filename+"_"+browserName+"_"+v+"_"+os+"_"+CommonMethods.formattedDate+".png"));
	}
	
	public static Boolean fn_CheckWebElementDisplayed(WebDriver driver, WebElement element, String elementname) {
		try {
			org.junit.Assert.assertEquals(elementname+" is not present on URL: "+driver.getCurrentUrl(), true, element.isDisplayed());
			return true;
		} catch (Exception e) {
			Assert.fail(elementname+" is in error and its not displaying on URL: "+driver.getCurrentUrl());
			return false;
		}
		
	}
	
	public boolean fn_PressESCKey(WebDriver driver) throws Exception {
		Actions actobj = new Actions(driver);
		actobj.sendKeys(Keys.ESCAPE).build().perform();
	return true;
	}
	
	public boolean fn_PressESCKeyonWebElement(WebDriver driver, WebElement ele) throws Exception {
//		ele.sendKeys(Keys.ESCAPE);
		Actions aobj = new Actions(driver);
		aobj.sendKeys(ele, Keys.ESCAPE).build().perform();
	return true;
	}

	public static String GetCurrentMonthYear() throws IOException{
		Calendar cal = Calendar.getInstance();
		String monthname = null;
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1; //zero-based
		if (month==1){
			monthname = "January";
		} else if(month==2){
			monthname = "February";
		} else if(month==3){
			monthname = "March";
		}else if(month==4){
			monthname = "April";
		}else if(month==5){
			monthname = "May";
		}else if(month==6){
			monthname = "June";
		}else if(month==7){
			monthname = "July";
		}else if(month==8){
			monthname = "August";
		}else if(month==9){
			monthname = "September";
		}else if(month==10){
			monthname = "October";
		}else if(month==11){
			monthname = "November";
		}else if(month==12){
			monthname = "December";
		}
		String currentmonthyear = monthname+" "+year;
		return currentmonthyear;
	
	}
	
	public static String GetNextMonth() throws IOException{
		Calendar cal = Calendar.getInstance();
		String monthname = null;
		int month = cal.get(Calendar.MONTH)+2; //zero-based
		if (month==13){
			monthname = "January";
		} else if(month==2){
			monthname = "February";
		} else if(month==3){
			monthname = "March";
		}else if(month==4){
			monthname = "April";
		}else if(month==5){
			monthname = "May";
		}else if(month==6){
			monthname = "June";
		}else if(month==7){
			monthname = "July";
		}else if(month==8){
			monthname = "August";
		}else if(month==9){
			monthname = "September";
		}else if(month==10){
			monthname = "October";
		}else if(month==11){
			monthname = "November";
		}else if(month==12){
			monthname = "December";
		}
		return monthname;
	
	}

	public static String tearDown(WebDriver Driver, List<Boolean> ResultArray,
			List<String> TestCaseNames) {
		int Tests = ResultArray.size();
		for (int i = 0; i < Tests; i++) {
			if (ResultArray.get(i).equals(true)) {
				if (i == 0) {
					System.out.println("Environment Setup Passed");
					reportContent = reportContent + "Environment Setup Passed";
				} else {
					System.out.println(TestCaseNames.get(i - 1) + "Passed");
					reportContent = reportContent + "<BR>"
							+ TestCaseNames.get(i - 1) + " Passed";
				}
			}
			if (ResultArray.get(i).equals(false)) {
				if (i == 0) {
					System.out.println("Environment Setup Failed");
					reportContent = reportContent + "Environment Setup Failed";
				} else {
					System.out.println(TestCaseNames.get(i - 1) + " Failed");
					reportContent = reportContent + "<BR><Font color =\"red\">"
							+ TestCaseNames.get(i - 1) + "Failed</font>";
				}
			}
		}
		System.out.println(ResultArray.toString());
		System.out.println(TestCaseNames.toString());
		Driver.quit();
		return reportContent;
	}

	//

	public static void myWriteAppend(String txtfile, String content)
			throws IOException {
		File file = new File(txtfile);

		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.append(content);
		bw.newLine();
		bw.close();
	}

	public static void myWriteEOF(String txtfile) throws IOException {
		File file = new File(txtfile);
		FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.newLine();
		bw.write("===== Run Completed=====");
		bw.newLine();
		bw.close();
	}

	public static void myWriteSOF(String txtfile) throws IOException {
		boolean fireup = (new File(txtfile)).mkdirs();
		if (!fireup) {
			System.out.println("Unable to locate Directory");
		}
		File file = new File(txtfile);
		if (file.exists() == true) {
			file.delete();
		}
		if (file.exists() == false) {
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("File Created on " + newdate);
			bw.newLine();
			bw.newLine();
			bw.close();
		}
	}

	public static void SOHTMLGENERAL(String Path) throws IOException {
		String Script = "<!DOCTYPE html><html>"
				+ "<title>Automation Test Suite Results</title>"
				+ "<body bgcolor =E5E4E2>"
				+ "<font face = \"calibri\"><img src=\"http://docs.seleniumhq.org/images/big-logo.png\" />"
				+ "<hr size=15 color= 48CCCD>"
				+ "<center><H2>Test Results</H2><br>"
				+ "<table border = \"0\" cellspacing = \"0\" cellpadding = \"0\" BGCOLOR =E5E4E2>"
				+ "<font face = \"calibri\"><tr><td>"
				+ "<table border = \"2\" cellspacing = \"0\" cellpadding = \"10\" BGCOLOR =53607E>"
				+ "<tr align=\"center\">"
				+ "<td><font size = 4 color=95B9C7><centre><b>#</td>"
				+ "<td><font size = 4 color=95B9C7><b>Test Case</td>"
				+ "<td><font size = 4 color=95B9C7><b>Test Step</td>"
				+ "<td><font size = 4 color=95B9C7><b>Result</td>" + "</tr>";
		myWriteAppend(Path, Script);
	}

	public static void GraphHTML(String Path) throws IOException {
		String Graph = "</table><table BGCOLOR =#A0A0A0><tr><td><br><input type=\"button\" id=\"mySavebutton\" onclick=\"createData()\" value=\"Save Results\"></td><td></td><td></td><td><br><input type=\"button\" id=\"myEditbutton\" onclick=\"this.disabled=true;document.getElementById('mySavebutton').disabled=false;\" value=\"Edit Results\" disabled></td></FORM></tr></table></td><td width=\"30%\" ><table width=\"100%\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\"BGCOLOR =\"white\"><tr><td><H2> Test Summary </H2></head><body style=\"font-family: verdana;border: 0 none;\"><div id=\"visualization\" style=\"width: 500px; height: 600px;\"></div></body></td></tr></table></td></font></font></table>";
		myWriteAppend(Path, Graph);

	}

	public static void EOHTMLGEN(String Path) throws IOException {
		String Content = "<P align=right><font size =1><i>Report Compiled Using Java and Selenium Webdriver<a href=\"http://www.java.com\"><img width=\"90\" height=\"100\"src=\"http://www.youngwebbuilder.com/wp-content/uploads/2012/10/Java-logo.png\" /></a><i></font></p></table></head><br>===========================================================<br>Selenium Test Suite Complete<br>===========================================================</html>";
		myWriteAppend(Path, Content);

	}

	public static File Screenshot(WebDriver mydriver) {
		scrshot = ((TakesScreenshot) mydriver).getScreenshotAs(OutputType.FILE);
		return scrshot;
	}
	
	public static void ImplicitWait(WebDriver driver, int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.MILLISECONDS);
		
	}
	
	public static String GetPastDateinyyyyMMdd() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());
	}
	
	public static String GetPreviousDate(String InputDate) throws ParseException {
		Date date = new SimpleDateFormat("E, d MMMM yyyy").parse(InputDate);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date myDate = dateFormat.parse(new SimpleDateFormat("yyyyMMdd").format(date));
		Date oneDayBefore = new Date(myDate.getTime() - 2);
		String onedaybeforedate = new SimpleDateFormat("yyyyMMdd").format(oneDayBefore);
		return onedaybeforedate;
	}
	
	public static String GetCurrentDateinddMMyyyy(String InputDate) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);    
        return dateFormat.format(cal.getTime());
	}
	
	public static String GetCurrentDateinDesiredFormat(String dateformat) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        return dateFormat.format(cal.getTime());
	}
	
	public static String GetFutureDateinDesiredFormat(String dateformat) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        return dateFormat.format(cal.getTime());
	}
	
	public static String GetPastDateinDesiredFormat(String dateformat) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(dateformat);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());
	}
	
	
//	public static void SetApplitoolsApiKey() throws ParseException {
//        eyes.setApiKey(Key);
//        eyes.setForceFullPageScreenshot(true);
//
//	}
	
	public Boolean fn_VisualValidation(WebDriver driver, String FileName) throws Exception {
		eyes.setMatchLevel(MatchLevel.LAYOUT2);
		eyes.checkWindow(FileName);
		return true;
	}
	
	public String[][] fn_Get2dArrayfromExcel(String sheetpath, String sheetname) throws IOException {
		String xl_FilePath = sheetpath;
		FileInputStream FISObj = new FileInputStream(xl_FilePath);
		@SuppressWarnings("resource")
		XSSFWorkbook XWbojObj = new XSSFWorkbook(FISObj);
		XSSFSheet XShtObj = XWbojObj.getSheet(sheetname);
		numberoflastrow = XShtObj.getPhysicalNumberOfRows();
		lastcellnumber = XShtObj.getRow(0).getLastCellNum();
		String[][] data = new String[numberoflastrow][lastcellnumber];

		DataFormatter formatter = new DataFormatter();
		
		for (int i = 0; i < numberoflastrow; i++) {
			Row row = XShtObj.getRow(i);
			if (row != null) {
				for (int j = 0; j < lastcellnumber; j++) {
					MissingCellPolicy MCP = Row.CREATE_NULL_AS_BLANK;
					Cell cell = row.getCell(j, MCP);
					if (!(formatter.formatCellValue(cell).equals(null)) || !(formatter.formatCellValue(cell).equals(""))) {
						try {
//							data[i][j] = cell.getStringCellValue();
							data[i][j] = formatter.formatCellValue(cell); 
						} catch (IllegalStateException e) {
							data[i][j] = new BigDecimal(formatter.formatCellValue(cell)).toPlainString().toString()
									.trim();
						}
					}
				}
			}
		}
		return data;
	}
	
	public int getStatusCode(String url) throws IOException{
		int statuscode = 0;
		URL url1 = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)url1.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		statuscode = connection.getResponseCode();
		return statuscode;
    }
	
	public String getfBaseUrl(){
		String[] urlArray = BaseURLFunctionalTests.split(",");
		if (urlArray.length>0) {
			return urlArray[0].trim();
		} else {
			return BaseURLFunctionalTests.trim();
		}
		
	}
	
	public String[] getVBaseURLArray() {
		String[] urlArray = BaseURLsVisualTest.split(",");
		return urlArray;
	}
	
	public static Boolean pressTabOnElement(WebElement element, WebDriver driver) {
		try {
			Actions actobj = new Actions(driver);
			actobj.moveToElement(element);
			element.sendKeys(Keys.TAB);
			actobj.build().perform();
			actobj.sendKeys(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
	public static Boolean clickAndHoldonElement(WebElement element, WebDriver driver) {
		try {
			Actions actobj = new Actions(driver);
			actobj.clickAndHold(element).build().perform();
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
//	public Boolean StopVisualValidation(WebDriver driver) throws Exception {
//		eyes.close();
//		eyes.abortIfNotClosed();
//		driver.close();
//		driver.quit();
//		return true;
//	}
}