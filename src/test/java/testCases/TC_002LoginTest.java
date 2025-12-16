package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC_002LoginTest extends BaseTest{
@Test(groups= {"Regression"})
	public void verify_login() {
//		logger.info("***********starting login test***************")
		try {
		//Home Page
		HomePage hp=new HomePage(driver);
		hp.clickOnMyAcc();
		hp.clickOnLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
//		lp.setEmailTxt(prop.getProperty("email"));
//        lp.setPasswordTxt(prop.getProperty("password"));
		lp.setEmailTxt(prop.getProperty("madhuri_uname"));
		lp.setPasswordTxt(prop.getProperty("madhuri_pwd"));
        lp.clickloginBtn();
        
        //MyAccountPage
        MyAccountPage myAcc=new MyAccountPage(driver);
        boolean targetapge=myAcc.isMyAccPageExists();
        
//        Assert.assertEquals(targetapge, true,"LoginFailed");//if fails then msg will be displayed
		 Assert.assertTrue(targetapge);
		 
		}catch(Exception e) {
			Assert.fail();
		}
		
//		logger.info(*************TC_002 Finished*****************)
	}
		
		
	
}
