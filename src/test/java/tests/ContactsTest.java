package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactsPage;
import pages.LoginPage;
import utilities.CommonUtilities;

public class ContactsTest extends BaseTest {


	WebDriver driver;
	String url;
	CommonUtilities utilities = new CommonUtilities();
	String username;
	String password;
	LoginPage login;
	LoginPageTest loginPageTest;
	ContactsPage contactsPage;
	//UserMenuDDPage userMenuDDPage;

	@BeforeMethod
	public void beforeMethodTest() throws IOException {
		loginPageTest = new LoginPageTest();		
		driver = loginPageTest.initialiseProperties();
		login = new LoginPage(driver);
		loginPageTest.login();
		contactsPage = new  ContactsPage(driver);
		//userMenuDDPage = new UserMenuDDPage(driver);

	}
	
	@Test
	public void createNewContact() {
		
		contactsPage.clickContactsTab();
		contactsPage.clickNewBtn();
		String description = contactsPage.getnewContactPage().getText();
		System.out.println(description);
		contactsPage.getLastName().sendKeys("dhanvin");
		contactsPage.clickSearchIcon();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent= it.next();
		String child = null;
		if(it.hasNext()) {
			child = it.next();
		}
		driver.switchTo().window(child);
		driver.switchTo().frame(contactsPage.getSearchFrame());
		contactsPage.getsearchBox().sendKeys("*a");
		contactsPage.clickGoBtn();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(contactsPage.getResultsFrame());
		contactsPage.clickSearchResult();
		driver.switchTo().window(parent);
		contactsPage.clickSaveBtn();
		contactsPage.getContactName().getText().contains("dhanvinn");
		System.out.println(contactsPage.getContactName().getText());
	}
	
	@Test
	public void createNewwView() {
		
		contactsPage.clickContactsTab();
		contactsPage.clickcreateNewViewLink();
		contactsPage.getViewName().sendKeys("Dhanvin");
		contactsPage.clickSaveBtn();
		Select contactDD = new Select(contactsPage.getContactsDD());
		contactDD.getFirstSelectedOption().getText().equalsIgnoreCase("Dhanvinn");
		System.out.println(contactDD.getFirstSelectedOption().getText());		
		
	}
	
	@Test
	public void recentContactsTest() {
		contactsPage.clickContactsTab();
		
		Select recentContactDD = new Select(contactsPage.getrecentContactDD());
		recentContactDD.selectByVisibleText("Recently Created");
		contactsPage.getnewContact().getText().contains("dhanvin");
		System.out.println(contactsPage.getnewContact().getText().contains("dhanvin"));
		
		
	}
	
	@Test
	public void viewMyContacts() {
	
		contactsPage.clickContactsTab();
		Select contactsDD = new Select(contactsPage.getContactsDD());
		contactsDD.selectByVisibleText("All Contacts");
		contactsPage.clickGoBtn();
		if(driver.getPageSource().contains("abcdefg"))
			System.out.println("New contacts Page");
		
	}
	
	@Test
	public void viewAContact() {
		
		contactsPage.clickContactsTab();
		contactsPage.clickAContactLink();
		
		/*
		 * if(driver.getPageSource().contains(contactsPage.getnewContact().getText())){
		 * System.out.println("The contact name is displayed"); }
		 */
	}
	
	@Test
	public void createNewViewErrorMsg() {
		
		contactsPage.clickContactsTab();
		contactsPage.clickcreateNewViewLink();
		contactsPage.getUniqueViewName().sendKeys("shuban");
		contactsPage.clickSaveBtn();
		contactsPage.isErrorDisplayed();
		System.out.println(contactsPage.isErrorDisplayed());
	}
	
	@Test
	public void cancelNewView() {
		contactsPage.clickContactsTab();
		contactsPage.clickcreateNewViewLink();
		contactsPage.getViewName().sendKeys("ABCD");
		contactsPage.getUniqueViewName().sendKeys("EFGH");
		contactsPage.clickCancelBtn();
		Select viewDD = new Select(contactsPage.getContactsDD());
		List<WebElement> viewDDoptions = viewDD.getOptions();
		boolean isfound = false;
		for(WebElement element:viewDDoptions) {
			if(element.getText().equals("ABCD")) {
				isfound = true;
				break;
			}
			
		}
		System.out.println(isfound);
		
	}
	
	@Test
	public void checkSaveAndNewTest() {
		
		contactsPage.clickContactsTab();
		contactsPage.clickNewBtn();
		contactsPage.getLastName().sendKeys("Indian");
		contactsPage.clickSearchIcon();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parent= it.next();
		String child = null;
		if(it.hasNext()) {
			child = it.next();
		}
		driver.switchTo().window(child);
		driver.switchTo().frame(contactsPage.getSearchFrame());
		contactsPage.getsearchBox().sendKeys("*a");
		contactsPage.clickGoBtn();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(contactsPage.getResultsFrame());
		contactsPage.clickSearchResult();
		driver.switchTo().window(parent);
		contactsPage.clickSaveAndNewBtn();
		
		System.out.println(contactsPage.isEditPage());
		System.out.println(driver.getPageSource().contains("Contact Edit"));
		
	}
}
