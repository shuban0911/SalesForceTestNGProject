package tests;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.UserMenuDDPage;

public class UserMenuDDTest extends  BaseTest{
	
	//LoginPage login;
	LoginPageTest loginPageTest;
	WebDriver driver;
	UserMenuDDPage userMenuDDPage;
	
	
	@BeforeMethod
	public void beforeMethodUserMenuDDTest() {
		
		loginPageTest = new LoginPageTest();
		driver = loginPageTest.initialiseProperties();
		userMenuDDPage = new UserMenuDDPage(driver);	
		
	}
	
	@Test
	public void myProfileTest() {
		userMenuDDOptionsisDispalyed();
		userMenuDDPage.clickMyProfileLink();
		editProfile();
		editFrameTest();
		shareContent();
		fileUpload();
		clickAddPhotoLink();
		uploadPhoto();
		
	}
	
	@Test
	public void mySettingsTest() {
		
		 userMenuDDOptionsisDispalyed(); 
		 userMenuDDPage.clickMySettingsLink();
		 userMenuDDPage.clickPersonalLink(); 
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true)",userMenuDDPage.getdisplayAndLayout()); 
		 userMenuDDPage.clickloginHistoryLink();
		 userMenuDDPage.clickdownLoadLink(); displayAndLayout();
		 
		 emailLinkTest();
		 clickCalendarsAndRemainder();	
		
		
	}
	
	@Test
	public void developerConsoleTest() {
		
		userMenuDDOptionsisDispalyed(); 
		userMenuDDPage.clickDeveloperConsole();
		Iterator<String> it = driver.getWindowHandles().iterator();

		String parentWindow= it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.close();
		driver.switchTo().window(parentWindow);
	}
	
	
	@Test
	public void logoutTest() {
			LoginPage loginPage = new LoginPage(driver);
			loginPageTest.login();
			userMenuDDPage.getlogoutLink().click();
			userMenuDDPage.waitForElement(10,loginPage.getvalidUserName());
			System.out.println(driver.getTitle());		
		
		
	}
	
	private boolean userMenuDDOptionsisDispalyed() {
		loginPageTest.login();
		boolean myProfileLink =  userMenuDDPage.getmyProfileLink().isDisplayed();
		boolean mySettingsLink = userMenuDDPage.getMySettingsLink().isDisplayed();
		boolean developerConsoleLink = userMenuDDPage.getdeveloperConsoleLink().isDisplayed();
		boolean switchToLightningExpLink = userMenuDDPage.getswitchToLightningExpLink().isDisplayed();
		boolean logoutLink = userMenuDDPage.getlogoutLink().isDisplayed();
		
		return (myProfileLink && mySettingsLink && developerConsoleLink && switchToLightningExpLink && logoutLink);
	}
	
	private void editProfile() {
		userMenuDDPage.clickEditContactLink();
	}
	
	public void editFrameTest() {
		userMenuDDPage.switchToEditContactFrame();
		userMenuDDPage.clickAboutTab();
		userMenuDDPage.getLastNameField().sendKeys("Dhanvin");
		userMenuDDPage.clickSaveAll();
		
	}
	
	private void shareContent() {
		
		userMenuDDPage.clickPostLink();
		driver.switchTo().frame(userMenuDDPage.gettextareaFrame());
		userMenuDDPage.clickTextArea().sendKeys("in textarea field");
		driver.switchTo().defaultContent();
		userMenuDDPage.clicksharebutton();
		 
	}
	
	private void fileUpload() {
		
		userMenuDDPage.clickFileLink();
		userMenuDDPage.clickuploadFromComputerButton();
		userMenuDDPage.chooseFileButton().sendKeys("C:\\Users\\jdman\\Documents\\testfile.txt");
		userMenuDDPage.clicksharebutton();
		
		
	}
	
	private void clickAddPhotoLink() {
				
			Actions action = new Actions(driver);
			action.moveToElement(userMenuDDPage.moderatorText()).perform();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()",userMenuDDPage.getAddPhotoLink());
		
	}
	
	private void uploadPhoto() {
		
		driver.switchTo().frame(userMenuDDPage.getuploadPhotoFrame());
		userMenuDDPage.getChoosePhoto().sendKeys("Downloads//pic1");
		//Actions action = new Actions(driver);
		//action.moveToElement(element).perform();
		//System.out.println(driver.findElement(By.name("j_id0:uploadFileForm")).getText());
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click()",element);		
		
	}
	
	private void displayAndLayout() {
		userMenuDDPage.clickDisplayAndLayout();
		userMenuDDPage.clickCustomizeTab();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",userMenuDDPage.getsaveButton());
		userMenuDDPage.selectCustomAppDD().selectByVisibleText("Salesforce Chatter");
		js.executeScript("arguments[0].scrollIntoView(true)",userMenuDDPage.getsaveButton());
		userMenuDDPage.selectgetAvailableTabs().selectByValue("Lead");
		userMenuDDPage.clickAddTab();
		userMenuDDPage.clickDownArrow();
		js.executeScript("window.scrollBy(0,500)");	
		 userMenuDDPage.clickBottomSaveBtn();
		
	}
	
	private void emailLinkTest() {
		userMenuDDPage.clickEmail();
		userMenuDDPage.clickmyEmailSettings();
		userMenuDDPage.getemailNameField().sendKeys("nov2022name");
		userMenuDDPage.getemailIdField().sendKeys("nov123@gg.com");
		userMenuDDPage.clickAutoBcc();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",userMenuDDPage.getsaveButton());
		userMenuDDPage.clickSaveButton();
		driver.switchTo().alert().accept();
		
	}
	
	private void clickCalendarsAndRemainder() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		userMenuDDPage.clickcalendarAndremainder();
		userMenuDDPage.clickActivityRemainder();
		js.executeScript("window.scrollBy(0,400)");
		userMenuDDPage.clickOpenTestRemainder();
		Iterator<String> it = driver.getWindowHandles().iterator();
		String parent = it.next();
		String child = null;
		while(it.hasNext()) {
			 child = it.next();
		}
		if(child!=null) {
			System.out.println("Pop up is displayed");
		}
		
		//WebElement text = driver.findElement(By.xpath("//div[contains(text(),'Sample Event.')]"));
		//text.getText();
		
	}
	
	
	
	
	

}
