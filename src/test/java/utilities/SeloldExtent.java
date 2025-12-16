package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseTest;

public class SeloldExtent extends BaseTest implements ITestListener {

	 WebDriver driver=null;
//public static ExtentReports extent=null;
//public static ExtentSparkReporter spark=null;
//public static ExtentTest test=null;
//public static Logger log = Logger.getLogger(BaseTest.class);
/*
	@Override
	public void onTestStart(ITestResult result) {
		String timeStamp=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
		repName = "Test-Report-" +timeStamp +".html";
//		extent=new ExtentReports();
		reportInit(result);
	
	/*	
		test=extent.createTest(result.getTestClass().getName());	
		
//		test=extent.createTest(result.getName());
//		String timeStamp=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
//		repName = "Test-Report-" +timeStamp +".html";
//		
//		spark=new ExtentSparkReporter("D://SeleniumByPavan/ecommVs3.1/target/"+repName+".html");
//		spark=new ExtentSparkReporter("D://SeleniumByPavan/ecommVs3.1//target//"+timeStamp+".html") ;
//			
//		extent.attachReporter(spark);
		
		
//		String timeStamp=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
//		repName = "Test-Report-" +timeStamp +".html";
		
		System.out.println("REP Name"+repName);
		spark=new ExtentSparkReporter("D://SeleniumByPavan/ecommVs3.1/target/"+repName);
//		extent=new ExtentReports();
		extent.attachReporter(spark);


	}*/



	@Override
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, "testcase pass Successfully");
	}



	@Override
	public void onTestFailure(ITestResult result) {
		try {
			
			test=extent.createTest(result.getTestClass().getName());
			String imgPath=new BaseTest().captureScreen(result.getName());
//			String imgPath=new BaseTest().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			test.log(Status.FAIL, result.getName()+" got Failed");
//			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		
	}



	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}



	@Override//my
	public void onStart(ITestContext context) {

		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println("time stamp===>"+timeStamp);
		repName = "Test-Report-" +timeStamp +".html";
		
//		sparkRepoter=new ExtentSparkReporter(".\\reports\\" + repName);
//		sparkRepoter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\reports\\"+repName);
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\"+repName);

		
		spark.config().setDocumentTitle("openCart Automation Report");
		spark.config().setReportName("Opencart Functional testing");
		spark.config().setTheme(Theme.DARK);
		/*
		extent=new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Application" , "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("SubModule", "Customer");
		extent.setSystemInfo("User Name", System.getProperty("user-name"));
		extent.setSystemInfo("Environment", "QA");

		String os=context.getCurrentXmlTest().getParameter("OS");
		extent.setSystemInfo("Operating System", os);

		String browser=context.getCurrentXmlTest().getParameter("Browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Included Group", includedGroups.toString());
		}
		*/
		extent=new ExtentReports();
		extent.attachReporter(spark);
//		
	}



	@Override
	public void onFinish(ITestContext context) {

//		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+"myReport.html";
////		String pathOfExtentReport=".\\reports\\"+repName;
//		File extentReport=new File(pathOfExtentReport);
//		
	
		extent.flush();
		String pathOfExtentReport="D://SeleniumByPavan/ecommVs3.1/target/"+repName;
//		String pathOfExtentReport=".\\reports\\"+repName;
		File extentReport=new File(pathOfExtentReport);
	/*	
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		*/
		
		
//		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
//		String pathOfExtentReport=".\\reports\\"+repName;
//		String pathOfExtentReport="D:\\SeleniumByPavan\\ecommVs3.1\\target"+repName;
//		File extentReport=new File(pathOfExtentReport);
		
	}


}
