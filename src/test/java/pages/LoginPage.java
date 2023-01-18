
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage  extends BasePage{
	
	
	public LoginPage(WebDriver driver) {
		 super(driver);
	 }
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement loginButton;
	
	@FindBy(id="userNavLabel")
	WebElement userMenuDD;
	
	@FindBy(id="error")
	WebElement errorMessage;
	
	@FindBy(id="rememberUn")
	WebElement rememberMe;
	
	@FindBy(id="forgot_password_link")
	WebElement forgotPasswordLink;
	
	@FindBy(id="idcard-identity")
	WebElement prefilledUsernameField;
	
	public void homePage() {
		waitForElement(10,userMenuDD);
		userMenuDD.click();
	}
	
	
	public  void enterUsername(String email) {
		userName.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin(){
		loginButton.click();
	}
	
	public String getBlankPwdErrorMsg() {
		waitForElement(10,errorMessage);
		return errorMessage.getText();
	}
	
	public String getUsername() {
		waitForElement(10,prefilledUsernameField);
		return prefilledUsernameField.getText();
	}
	
	public void selectRememberMe() {
		waitForElement(10,rememberMe);
		rememberMe.click();
	}
	
	public void forgotPasswordLinkClick() {
		forgotPasswordLink.click();
	}
	
	public WebElement getvalidUserName() {
		return userName;
	}
	
	public WebElement getvalidPassword() {
		return password;
	}
	
}