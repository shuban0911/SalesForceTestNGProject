package tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateOpportunityPage;
import pages.LoginPage;
import pages.UserMenuDDPage;
import utilities.CommonUtilities;
import utilities.ExcelUtilities;

public class CreateOpportunityTest extends BaseTest {

	WebDriver driver;
	String url;
	CommonUtilities utilities = new CommonUtilities();
	String username;
	String password;
	LoginPage login;
	UserMenuDDPage userMenuDDPage;
	CreateOpportunityPage createOpportunityPage;
	LoginPageTest loginPageTest;

	@BeforeMethod
	public void beforeMethodTest() throws IOException {
		loginPageTest = new LoginPageTest();
		driver = loginPageTest.initialiseProperties();
		login = new LoginPage(driver);
		userMenuDDPage = new UserMenuDDPage(driver);
		createOpportunityPage = new CreateOpportunityPage(driver);
		loginPageTest.login();

	}

	@Test
	public void opportunitiesDDTest() {

		createOpportunityPage.clickOpportunitiesTab();
		boolean isOpphome = createOpportunityPage.isopportunyhomepage();
		System.out.println(isOpphome);
		Select opportunityDD = new Select(createOpportunityPage.getOpptunityDD());

		List<WebElement> options = opportunityDD.getOptions();
		java.util.Iterator<WebElement> it = options.iterator();

		while (it.hasNext()) {

			WebElement element = it.next();
			System.out.println(element.getAttribute("text"));
		}

	}

	@Test
	public void createNewOpportunity() {

		createOpportunityPage.clickOpportunitiesTab();
		createOpportunityPage.clickNewOpportunity();
		createOpportunityPage.getOpportunityName().sendKeys("Newww");
		createOpportunityPage.getAccountName().sendKeys("ShubanDhanvin");
		createOpportunityPage.getcloseDate().sendKeys(getformattedDate());
		Select stageDD = new Select(createOpportunityPage.getStageDD());
		stageDD.selectByVisibleText("Qualification");
		createOpportunityPage.getProbability().sendKeys("0.5");
		Select leadSourceDD = new Select(createOpportunityPage.getLeadSource());
		leadSourceDD.selectByVisibleText("Other");
		createOpportunityPage.clickSearchIcon();
		Set<String> windows = driver.getWindowHandles();
		java.util.Iterator<String> it = windows.iterator();
		String parent = it.next();
		String child = it.next();

		driver.switchTo().window(child);
		driver.switchTo().frame(createOpportunityPage.getsearchFrame());
		createOpportunityPage.getsearchBox().sendKeys("*a");
		createOpportunityPage.clickGoBtn();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(createOpportunityPage.getresultsFrame());
		createOpportunityPage.clickfirstsearchoption();
		driver.switchTo().window(parent);
		System.out.println(createOpportunityPage.newopportunitypage().getText());
		createOpportunityPage.clickSaveBtn();

	}
	
	private String getformattedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(new Date());
		return date;
	}

	@Test
	public void opportunityPipelineReport() {

		createOpportunityPage.clickOpportunitiesTab();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", createOpportunityPage.getPipelineLink());
		createOpportunityPage.clickOppPipelineLink();
		utilities.takeScreenshot(driver);

	}

	@Test
	public void stuckOpportunitiesLink() {

		createOpportunityPage.clickOpportunitiesTab();
		createOpportunityPage.clickstuckOpportunityLink();
		utilities.takeScreenshot(driver);

	}
	
	
	@Test(dataProvider = "reportdata")
	public void quaterlyReport(String interval,String include) {
		
		createOpportunityPage.clickOpportunitiesTab();
		Select intervalDD = new Select(createOpportunityPage.getIntervalDD());
		Select includeDD = new Select(createOpportunityPage.getIncludeDD());
		intervalDD.selectByVisibleText(interval);
		includeDD.selectByVisibleText(include);
		createOpportunityPage.clickrunReportBtn();
		utilities.takeScreenshot(driver);		

	}
	
	@DataProvider(name = "reportdata")
	public String[][] validUserLogindata() throws EncryptedDocumentException, IOException {
		return ExcelUtilities.getExcelData("Report");
	}

}
