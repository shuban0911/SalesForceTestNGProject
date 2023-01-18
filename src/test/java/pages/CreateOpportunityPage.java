package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CreateOpportunityPage extends BasePage{
	
	public CreateOpportunityPage(WebDriver driver) {
		 super(driver);
	 }
	
	@FindBy(id="Opportunity_Tab")
	WebElement opportunitiesTab;
	
	@FindBy(xpath="//img[@title='Opportunity']/following-sibling::h1[text()='Opportunities']")
	WebElement opportunituesHome;
	
	@FindBy(id="fcf")
	WebElement opportunityDD;
	
	@FindBy(xpath="//select[@id='fcf']/option")
	List<WebElement> opportunityOptions;
	
	@FindBy(name="new")
	WebElement newOpportunity;
	
	@FindBy(id="opp3")
	WebElement opportunityName;
	
	@FindBy(id="opp4")
	WebElement accountName;
	
	@FindBy(id="opp9")
	WebElement closeDate;
	
	@FindBy(id="opp11")
	WebElement StageDD;
	
	@FindBy(id="opp12")
	WebElement probability;
	
	@FindBy(id="opp6")
	WebElement leadSource;
	
	@FindBy(id="opp17_lkwgt")
	WebElement searchicon;
	
	@FindBy(id="lksrch")
	WebElement searchbox;
	
	@FindBy(id="searchFrame")
	WebElement searchframe;
	
	@FindBy(xpath="//input[@title='Go!']")
	WebElement goBtn;
	
		
	@FindBy(xpath="//table[@class='list']//tr[2]//a")
	WebElement firstsearchoption;
	
	@FindBy(xpath="//frame[@id='resultsFrame']")
	WebElement resultsFrame;
	
	@FindBy(xpath="//h2[@class='pageDescription' and contains(text(),' New Opportunity')]")
	WebElement newopportunitypage;
	
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]")
	WebElement oppPipeline;
	
	@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]")
	WebElement stuckOpportunities;
	
	@FindBy(id="quarter_q")
	WebElement intervelDD;
	
	@FindBy(id="open")
	WebElement includeDD;
	
	@FindBy(xpath="//input[@value='Run Report']")
	WebElement runReportBtn;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	
	public void clickOpportunitiesTab() {
		waitForElement(10, opportunitiesTab);
		opportunitiesTab.click();
	}
	
	public boolean isopportunyhomepage() {
		waitForElement(10, opportunitiesTab);
		return opportunituesHome.isDisplayed();
	}
	
	public WebElement getOpptunityDD() {
		waitForElement(10, opportunityDD);
		return opportunityDD;
	}

	
	public void clickNewOpportunity() {
		waitForElement(10, newOpportunity);
		newOpportunity.click();
	}
	
	public WebElement getOpportunityName() {
		waitForElement(10, opportunityName);
		return opportunityName;
	}
	
	public WebElement getAccountName() {
		waitForElement(10, accountName);
		return accountName;
	}
	
	public WebElement getcloseDate() {
		waitForElement(10, closeDate);
		return closeDate;
	}
	
	public WebElement getStageDD() {
		waitForElement(10, StageDD);
		return StageDD;
	}
	
	public WebElement getProbability() {
		waitForElement(10, probability);
		return probability;
	}
	
	public WebElement getLeadSource() {
		waitForElement(10, leadSource);
		return leadSource;
	}
	
	public void clickSearchIcon() {
		waitForElement(10, searchicon);
		searchicon.click();
		
	}
	
	public WebElement getsearchBox() {
		waitForElement(10, searchbox);
		return searchbox;
	}
	
	public WebElement getsearchFrame() {
		waitForElement(10, searchframe);
		return searchframe;
	}
	
	public void clickGoBtn() {
		waitForElement(10, goBtn);
		goBtn.click();
	}
	
	
	public void clickfirstsearchoption() {
		waitForElement(10, firstsearchoption);
		firstsearchoption.click();
	}
	
	public WebElement getresultsFrame() {
		waitForElement(20, resultsFrame);
		return resultsFrame;
	}
	
	public WebElement newopportunitypage() {
		waitForElement(10, newopportunitypage);
		return newopportunitypage;
	}
	
	public void clickOppPipelineLink() {
		waitForElement(10, oppPipeline);
		oppPipeline.click();
	}
	
	public WebElement getPipelineLink() {
		waitForElement(10, oppPipeline);
		return oppPipeline;
	}
	
	public void clickstuckOpportunityLink() {
		waitForElement(10, stuckOpportunities);
		stuckOpportunities.click();
	}
	
	public WebElement getIncludeDD() {
		waitForElement(10, includeDD);
		return includeDD;
	}
	
	public WebElement getIntervalDD() {
		waitForElement(10, intervelDD);
		return intervelDD;
	}
	
	public void clickrunReportBtn() {
		waitForElement(10, runReportBtn);
		runReportBtn.click();
	}
	
	public void clickSaveBtn() {
		waitForElement(10, saveBtn);
		saveBtn.click();
	}
}
