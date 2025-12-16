package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;


public class TC_003LoginDDT extends BaseTest{

	/*// Data is valid::
	      *  login Successful==>pass=====>logout
	      *  login unsucessful==>failed
	   
	  // Data is invalid
	       *login Sucessfull==>failed====>logout
	       *login Unsucessfull==>Pass 
	
	
	*/
	@Test(dataProvider="LoginTestData", dataProviderClass=DataProviders.class, groups={"Regression"})
	public void verify_LoginDDT(String email, String password,String expRes) {
	//logger.info("**************Tc003 Started*****************")	
	try {	
		
		HomePage hp=new HomePage(driver);
		hp.clickOnMyAcc();
		hp.clickOnLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmailTxt(email);
		lp.setPasswordTxt(password);
		lp.clickloginBtn();
        
        //MyAccountPage
        MyAccountPage myAcc=new MyAccountPage(driver);
        boolean targetPage=myAcc.isMyAccPageExists();
		
        if(expRes.equalsIgnoreCase("valid")) {
        	if(targetPage==true) {
        		myAcc.logOut();
        		Assert.assertTrue(true);
        		
        	}else {
        		Assert.assertTrue(false);
        	}
        }
		
        
        if(expRes.equalsIgnoreCase("Invalid")) {
        	if(targetPage==true) {
        		myAcc.logOut();
        		Assert.assertTrue(false);
        		
        	}else {
        		Assert.assertTrue(true);
        	}
        }
	}catch(Exception e) {
		Assert.fail();
	}
//        logger.info("***************TC003 is Finished**************")
	}
	
	
	
	
	
	
	
}
