package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
 public AccountRegistrationPage(WebDriver driver) {
	 super(driver);
 }
 
 @FindBy(id="input-firstname")
 WebElement fName;
 
 @FindBy(id="input-lastname")
 WebElement lName;
 
 @FindBy(id="input-email")
 WebElement mail;
 
 @FindBy(id="input-telephone")
 WebElement telephone;
 
 @FindBy(id="input-password")
 WebElement password;
 
 @FindBy(id="input-confirm")
 WebElement confirm_password;
 
 @FindBy(xpath="//input[@type='checkbox']")
 WebElement privacyPolicy;
 
 @FindBy(xpath="//input[@type='submit']")
 WebElement continueBtn;
 
 @FindBy(xpath="//div[@id='content']/h1[text()='Your Account Has Been Created!']")
 WebElement confirm_msg;
 
 public void setFname(String firstName) {
	 fName.sendKeys(firstName);
 }
 
 public void setLname(String lastName) {
	 lName.sendKeys(lastName);
 }
 
 public void setEmail(String email) {
	 mail.sendKeys(email);
 }
 
 public void setTelephone(String telephn) {
	 telephone.sendKeys(telephn);
 }
  
 public void setPassword(String pwd) {
	 password.sendKeys(pwd);
 }
 
 public void setConfirmPassword(String pwd) {
	 confirm_password.sendKeys(pwd);
 }
  public void clickOnPrivacyChk() {
	  privacyPolicy.click(); 
  }
  public void clickOnContinueBtn() {
	  continueBtn.click();
  }
  public String getconfirm_msg() {
	  try {
	  return confirm_msg.getText();
	  }catch(Exception e) {
		return(e.getMessage());
	  }
  }
}
