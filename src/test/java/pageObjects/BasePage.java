package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasePage {
public static WebDriver driver;
/*		public static ExtentReports report=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	public static Logger log = Logger.getLogger(BasePage.class);
	
	public void reportInit() {
		report=new ExtentReports();
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		report.attachReporter(spark);
	}
	*/
//	 WebDriver driver;
	 public BasePage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }

	 
}
