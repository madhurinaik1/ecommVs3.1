package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.implementation.bind.annotation.Super;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement logOut_btn;
	
	public boolean isMyAccPageExists() {
		try {
		return (myHeading.isDisplayed());
     	}
		catch(Exception e){
     		return false;
     	}
	}
	
	public void logOut() {
		logOut_btn.click();
	}
}
