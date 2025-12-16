package testCases;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC_001AccountRegTest extends BaseTest {
	@Test(groups= {"Sanity"})
	public void verify_acc_registration() throws InterruptedException {
		
//		logger.info("**************starting TC_001AccountReg Test**********");
		
		
		HomePage hp=new HomePage(driver);
		hp.clickOnMyAcc();
		hp.clickOnRegi();
		
//		logger.info("******Clicked on my account************");
		
		AccountRegistrationPage reg=new AccountRegistrationPage(driver);
		reg.setFname(generateRandomString().toUpperCase());
		reg.setLname(generateRandomString().toUpperCase());
		reg.setEmail(generateRandomString()+"@gmail.com");
		reg.setTelephone(generateRandomNumber());
		
		String pwd=generateRandomAlphaNumeric();
		reg.setPassword(pwd);
		reg.setConfirmPassword(pwd);
		
		reg.clickOnPrivacyChk();
		reg.clickOnContinueBtn();
		
		 Thread.sleep(3000);
//		 logger.info("*****validati ng res msg**************");
		String act_confirmMsg=reg.getconfirm_msg();
	    Assert.assertEquals(act_confirmMsg, "Your Account Has Been Created!");

	}
	
	

	
}