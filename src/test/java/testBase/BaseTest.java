package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class BaseTest {
public	static WebDriver driver;
//
//
//public static ExtentReports extent=null;
//public static ExtentSparkReporter spark=null;
//public static ExtentTest test=null;
//public static Logger log = Logger.getLogger(BaseClass.class);

//

public static ExtentReports extent=null;
public static ExtentSparkReporter spark=null;
public static ExtentTest test=null;
public static Logger log = Logger.getLogger(BaseTest.class);


//public Logger logger;
	public Properties prop;
	public String repName=null;
	@BeforeClass
	@Parameters({"OS","Browser"})
	public void setup(String os, String browser) throws IOException {
		System.out.println("Browser====>"+browser);
//		logger=LogManager.getLogger(this.getClass());
		
//		FileReader file=new FileReader("./src//test//resources//config.properties");
		FileReader file=new FileReader("D:\\SeleniumByPavan\\ecommVs3.1\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(file);
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
		
			//operating System
			if(os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WINDOWS);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("NO Matching os");
				return;
			}
			
			//browser
			
			switch(browser.toLowerCase()) {
			case "chrome":capabilities.setBrowserName("Chrome"); break;
			case "edge":capabilities.setBrowserName("MicrosofEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			driver=new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"),capabilities);
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")){
			switch(browser.toLowerCase()){
			case "chrome" :driver=new ChromeDriver(); break;
			case "firefox" : driver=new FirefoxDriver(); break;
			default: System.out.println("invalid entry");return;

		}
	}
		
		
		
		
		
		
		
			
			
//		driver=new ChromeDriver();
//		driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("appUrl"));//reading propertires file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
				
	}

	public void reportInit(ITestResult result) {
		extent=new ExtentReports();
		String timeStamp=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date()).toString();
       
		
		String rootDir=System.getProperty("user.dir")+"/target/";
        String fileExtension = ".html";
//		String fullPath=rootDir + timestamp + fileExtension;
//		String timeStamp=new SimpleDateFormat("yyyy:MM:dd").format(new Date());
System.out.println("TIMESTAPM"+ timeStamp);
//				repName = "Test-Report-"+timeStamp;
				repName = "Test-Report-" +timeStamp +".html";
//		repName = timeStamp+".html";
//		repName=timeStamp+"-Test-Report";
		
//		repName="Test-Report"+timeSt;
		
		//google
//				String reportFileName =  timestamp +"ExtentReport" + ".html";
				
		
//		System.out.println("REP Name===> "+repName);		
//		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportFileName);
				
//			extent.attachReporter(spark);
//	}
//			
//		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/src/reports/"+repName);
//System.out.println("=====> "+fullPath);
//		spark=new ExtentSparkReporter(fullPath);
//		spark=new ExtentSparkReporter("D://SeleniumByPavan/ecommVs3.1/target/"+reportFileName);
//		spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/target/"+reportFileName);
		spark=new ExtentSparkReporter("D://SeleniumByPavan/ecommVs3.1/target/ExtentReport");
//		extent.attachReporter(spark);
		
//		test=extent.createTest(result.getName());
//		String timeStamp=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
//		repName = "Test-Report-" +timeStamp;
//		
//		spark=new ExtentSparkReporter("D://SeleniumByPavan//ecommVs3.1//target//"+repName);

//			
		extent.attachReporter(spark);	
		
		
	}

	
	@AfterClass
	public void tearDown() {
	
		driver.close();
	}

	public String generateRandomString() {
		
		String randomString=RandomStringUtils.randomAlphabetic(5);
		return randomString;
	}

public String generateRandomNumber() {
		
		String randomNumeric=RandomStringUtils.randomNumeric(5);
		return randomNumeric;
	}
public String generateRandomAlphaNumeric() {
	
	String randomAlphaNum=RandomStringUtils.randomAlphanumeric(5);
	return randomAlphaNum;
}

	public String captureScreen(String tname) throws IOException {
	
	String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	TakesScreenshot ts=(TakesScreenshot) driver;
	
	File sourceFile=ts.getScreenshotAs(OutputType.FILE);
	
//	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"-"+timeStamp+".png" ;
	
//	String targetFilePath=System.getProperty("user.dir")+"\\target\\"+tname+"-"+timeStamp+".png" ;

	String targetFilePath="D://SeleniumByPavan/ecommVs3.1//screenshots//"+tname+"-"+timeStamp+".png" ;
    System.out.println("target file===>"+targetFilePath);
	
   File targetFile=new File(targetFilePath);
	
//	FileUtils.copyDirectory(sourceFile, targetFile);
	sourceFile.renameTo(targetFile);
	return targetFilePath;

//	
	
	
}

}
