package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailTxt;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTxt;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	

	public void setEmailTxt(String email) {
		emailTxt.sendKeys(email);
	}

	public void setPasswordTxt(String  password) {
		passwordTxt.sendKeys(password);
	}

	public void clickloginBtn() {
		 loginBtn.click();;
	}

	
	
	
	
	
	

}
