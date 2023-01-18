package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Leads']")
	WebElement leadsTab;
	
	@FindBy(xpath="//img[@title='Lead' and @class='pageTitleIcon']")
	WebElement leadsIcon;
	
	@FindBy(id="fcf")
	WebElement viewDD;
	
	@FindBy(xpath="//select[@id='fcf']//option")
	List<WebElement> options;
	
	@FindBy(xpath="//input[contains(@value,'Go!')] ")
	WebElement goBtn;
	
	@FindBy(xpath="//input[@name='new']")
	WebElement newBtn;
	
	@FindBy(id="name_lastlea2")
	WebElement lastname;
	
	@FindBy(id="lea3")
	WebElement companyName;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	@FindBy(xpath="//h2[@class='topName']")
	WebElement saveLeadLandingPg;
	
	public void clickLeadsTab() {
		waitForElement(10, leadsTab);
		leadsTab.click();
	}
	
	public boolean isLeadsIconpresent() {
		waitForElement(10, leadsIcon);
		return leadsIcon.isDisplayed();
	}
	
	public WebElement getViewDD() {
		waitForElement(10, viewDD);
		return viewDD;
	}
	
	public List<WebElement> getoptions(){
		return options;
	}
	
	public void clickGoBtn() {
		goBtn.click();
	}
	
	public void clickNewBtn() {
		waitForElement(10, newBtn);
		newBtn.click();
	}
	
	public WebElement getLastName() {
		waitForElement(10, lastname);
		return lastname;
	}
	
	public WebElement getCompanyName() {
		waitForElement(10, companyName);
		return companyName;
	}
	
	public void clickSaveBtn() {
		waitForElement(10, saveBtn);
		saveBtn.click();
	}
	
	public WebElement getsaveLeadLandingPg() {
		waitForElement(10, saveLeadLandingPg);
		return saveLeadLandingPg;
	}

}
