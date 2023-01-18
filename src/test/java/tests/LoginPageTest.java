package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.UserMenuDDPage;
import utilities.CommonUtilities;
import utilities.ExcelUtilities;

public class LoginPageTest extends BaseTest {
	WebDriver driver;
	String url;
	CommonUtilities utilities = new CommonUtilities();
	String username;
	String password;
	LoginPage login;
	UserMenuDDPage userMenuDDPage ;
	
	@BeforeMethod
	public void beforeMethodLoginTest() throws IOException {
		
		driver = initialiseProperties();		
		
		
	}
	
	@Test(priority=1 , dataProvider = "logindata")
	public void validUserTest(String Username,String Password) {
		try {	
			username = Username;
			password = Password;
		login();
		login.homePage();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=2 ,enabled =false)
	public void passwordFieldEmptyMsgTest() {
		try {
			login.enterUsername(username);
			login.enterPassword("");
			login.clickLogin();
			if(login.getBlankPwdErrorMsg().equalsIgnoreCase(utilities.getproperty("expectedErrorMsg"))) {
				System.out.println(login.getBlankPwdErrorMsg());
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	@Test(priority=3,enabled =false)
	public void rememberMeTest() {
		try {
			login.enterUsername(username);
			login.enterPassword(password);
			login.selectRememberMe();
			login.clickLogin();
			userMenuDDPage = new UserMenuDDPage(driver);
			userMenuDDPage.logoutUser(userMenuDDPage);
			
			if(login.getUsername()!=null) {
				System.out.println(driver.findElement(By.id("idcard-identity")).getText());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void forgotPasswordTest() {
		try {
			login.enterUsername(username);
			login.forgotPasswordLinkClick();
			String window = driver.getWindowHandle();
			driver.switchTo().window(window);
			WebElement element = driver.findElement(By.xpath("//input[@id='un']"));
			element.sendKeys("oct2022@abcd.com");
			driver.findElement(By.id("continue")).click();
			String window1 = driver.getWindowHandle();
			driver.switchTo().window(window1);
			String header = driver.findElement(By.xpath("//h1[contains(text(),'Check Your Email')]")).getText();
			if(header.equalsIgnoreCase("Check Your Email")) {
				System.out.println("passed");
			}
			
		}catch(Exception e) {
			
		}
	}
	
	public WebDriver initialiseProperties() {
		try {
		url = utilities.getproperty("url");
		username = utilities.getproperty("username");
		password = utilities.getproperty("password");
		driver= getDriver("chrome");
		driver.get(url);
		driver.manage().window().maximize();
		login = new LoginPage(driver);		
		}
		catch(Exception e) {
			System.out.println("Initialising elements");
		}
		return driver;
	}
	
	public void login() {
		try {			
			login.getvalidUserName().sendKeys(username);			
			login.getvalidPassword().sendKeys(password);
			login.clickLogin();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void teardown() {
		CommonUtilities common = new CommonUtilities();
		common.takeScreenshot(driver);
		driver.close();
	}
	
	@DataProvider(name = "logindata")
	public String[][] validUserLogindata() throws EncryptedDocumentException, IOException {
		return ExcelUtilities.getExcelData("Login");
	}
	

}
