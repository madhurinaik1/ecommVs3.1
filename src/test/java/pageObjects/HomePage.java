package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
    WebElement myAccountLink;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement RegistrationLink;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginLink;
	
	public void clickOnMyAcc() {
		myAccountLink.click();
	}
	
	public void clickOnRegi() {
		RegistrationLink.click();
	}
	
	public void clickOnLogin() {
		loginLink.click();
	}
}
