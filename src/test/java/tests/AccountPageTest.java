package tests;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.LoginPage;
import pages.UserMenuDDPage;
import utilities.CommonUtilities;

public class AccountPageTest extends BaseTest {
	
	WebDriver driver;
	String url;
	CommonUtilities utilities = new CommonUtilities();
	String username;
	String password;
	LoginPage login;
	UserMenuDDPage userMenuDDPage ;
	AccountPage accountPage;
	LoginPageTest loginPageTest;
	
	@BeforeMethod
	public void beforeMethodTest() throws IOException {
		loginPageTest = new LoginPageTest();
		driver = loginPageTest.initialiseProperties();
		login = new LoginPage(driver);
		userMenuDDPage = new UserMenuDDPage(driver);	
		accountPage = new AccountPage(driver);
		loginPageTest.login();
		
	}
	
	
	@Test
	public void createNewAccount() {
	
		accountPage.clickAccountTab();		
		accountPage.clicknewAccountBtn();		
		accountPage.getaccountName().sendKeys("ShubanDhanvin11");
		Select typeDD = new Select(accountPage.gettype());
		typeDD.selectByValue("Technology Partner");
		Select customerPriority = new Select(accountPage.getcustomerPriority());
		customerPriority.selectByValue("High");
		accountPage.clickSaveBtn();
	}
	
	@Test
	public void createNewViewTest() {
		
		accountPage.clickAccountTab();	
		accountPage.clickcreatenewviewBtn();
		accountPage.getViewname().sendKeys("ShubanDhanvin9911");
		accountPage.getViewuniquename().sendKeys("ShubanDhanvin818");
		accountPage.clickcreatenewviewsaveBtn();
		Select nameDD = new Select(accountPage.getviewNameDD());
		String viewname = nameDD.getFirstSelectedOption().getText();
		System.out.println(viewname);
		Assert.assertEquals(viewname, "ShubanDhanvin9911");
	}
	
	@Test
	public void editViewTest() {
		
		accountPage.clickAccountTab();	
		Select nameDD = new Select(accountPage.getviewNameDD());
		nameDD.selectByVisibleText("ShubanDhanvin9911");
		accountPage.clickEditBtn();
		accountPage.getViewname().sendKeys("Shuban11Dhanvin");
		accountPage.getViewuniquename().sendKeys("Shuban11Dhanvin");
		accountPage.clickeditSaveBtn();
		String viewname = nameDD.getFirstSelectedOption().getText();
		System.out.println(viewname);
		Assert.assertEquals(viewname, "Shuban11Dhanvin");
		
	}
	
	@Test
	public void mergeAccountTest() {
		
		accountPage.clickAccountTab();	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",accountPage.getReportsLink());
		accountPage.clickMergeAccount();
		accountPage.getmergeAccountId().sendKeys("ShubanDhanvin");
		accountPage.clickFindAccountBtn();
		List<WebElement> accounts = accountPage.getAccountOption();
		
		Iterator<WebElement>  it = accounts.iterator();
		int count = 0;
		while(it.hasNext() && count<3 ) {
			it.next().click();
			count++;
		}
		
		accountPage.clickNext();
		accountPage.clickmergeBtn();
		driver.switchTo().alert().accept();
		
	}
	
	
	@Test
	public void createAccountReport() {
		
		accountPage.clickAccountTab();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",accountPage.getReportsLink());
		accountPage.clickreportLink();
		accountPage.clickdateField();
		Actions action = new Actions(driver);
		action.click(accountPage.getcreatedDateOption()).build().perform();
		accountPage.getStartDate().sendKeys(getformattedDate());
		accountPage.getendDateMonthAndYear().sendKeys(getformattedDate());;
		accountPage.clickmergeReportsaveBtn();
		accountPage.getreporttNameField().sendKeys("ShubanDhanvinnewwsdf");
		
		accountPage.getReportUniqueName().clear();
		accountPage.getReportUniqueName().sendKeys("viewwsdg");
		//js.executeScript("arguments[0].click();", accountPage.getSAveAndRunReport());
		//action.moveToElement(accountPage.getSAveAndRunReport());
		//action.click(accountPage.getSAveAndRunReport());
		accountPage.clicksaveAndrunreport();
		
		
	}
	
	private String getformattedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String date = sdf.format(new Date());
		return date;
	}
	

}
