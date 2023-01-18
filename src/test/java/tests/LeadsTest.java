package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LeadsPage;
import pages.LoginPage;
import pages.UserMenuDDPage;
import utilities.CommonUtilities;

public class LeadsTest extends BaseTest {
	
	WebDriver driver;
	String url;
	CommonUtilities utilities = new CommonUtilities();
	String username;
	String password;
	LoginPage login;
	LoginPageTest loginPageTest;
	UserMenuDDPage userMenuDDPage;
	LeadsPage leadsPage;

	@BeforeMethod
	public void beforeMethodTest() throws IOException {
		loginPageTest = new LoginPageTest();		
		driver = loginPageTest.initialiseProperties();
		login = new LoginPage(driver);
		loginPageTest.login();
		leadsPage = new LeadsPage(driver);
		userMenuDDPage = new UserMenuDDPage(driver);

	}
	
	
	@Test
	public void checkLeadsTabTest() {
		leadsPage.clickLeadsTab();
		leadsPage.isLeadsIconpresent();
		System.out.println(leadsPage.isLeadsIconpresent());
	}
	
	@Test
	public void leadsSelectViewTest() {
		leadsPage.clickLeadsTab();
		List<WebElement> options = leadsPage.getoptions();
		for(WebElement option :options) {
			System.out.println(option.getText());
		}
	}
	
	@Test
	public void goButtonTest() {
		leadsPage.clickLeadsTab();
		Select optionDD = new Select(leadsPage.getViewDD());
		optionDD.selectByVisibleText("Recently Viewed Leads");
		userMenuDDPage.logoutUser(userMenuDDPage);
		login = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(login.getvalidUserName()));
		login.getvalidUserName().sendKeys("oct2022@abcd.com");			
		login.getvalidPassword().sendKeys("shuban0911");
		login.clickLogin();
		leadsPage.clickLeadsTab();
		WebElement selectedOption = optionDD.getFirstSelectedOption();
		System.out.println(selectedOption.getText());
		if(selectedOption.getText().equalsIgnoreCase("Recently Viewed Leads")) {
			System.out.println("last selected option is retained" );
		}
		leadsPage.clickGoBtn();
		}
	
	@Test
	public void todaysLeadsTest() {
		leadsPage.clickLeadsTab();
		Select optionDD = new Select(leadsPage.getViewDD());
		optionDD.selectByVisibleText("Today's Leads");
		utilities.takeScreenshot(driver);
		
	}
	
	@Test
	public void createNewLeadTest() {
		leadsPage.clickLeadsTab();
		leadsPage.clickNewBtn();
		leadsPage.getLastName().sendKeys("ABCD");
		leadsPage.getCompanyName().sendKeys("ABCD");
		leadsPage.clickSaveBtn();
		String lastname = leadsPage.getsaveLeadLandingPg().getText();
		System.out.println(lastname);
		
	}
		
	}


