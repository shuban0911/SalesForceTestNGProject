package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AccountPage  extends BasePage{
	
	
	public AccountPage(WebDriver driver) {
		 super(driver);
	 }
	
	@FindBy(id="Account_Tab")
	WebElement accountTab;
	
	@FindBy(name="new")
	WebElement newAccntBtn;
	
	@FindBy(id="acc2")
	WebElement accountName;
	
	@FindBy(id="acc6")
	WebElement typeDD;
	
	@FindBy(id="00NDn000006w8XB")
	WebElement customerPriority;
	
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@name='save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement createnewviewBtn;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="devname")
	WebElement viewUniquename;
	
	@FindBy(name="save")
	WebElement createnewviewsaveBtn;
	
	@FindBy(xpath="//select[@title='View:']")
	WebElement viewNameDD;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editBtn;
	
	@FindBy(xpath="//div[@class='pbHeader']//input[@title='Save']")
	WebElement editSaveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Merge Accounts')]")
	WebElement mergeAccountLink;
	
	@FindBy(xpath = "//a[contains(text(),'Go to Reports')]")
	WebElement gotoReportsLink;
	
	@FindBy(xpath="//input[@id='srch']")
	WebElement mergeAccountId;
	
	@FindBy(xpath="//input[@value='Find Accounts']")
	WebElement findAccountBtn;
	
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> accountOptions;
	
	@FindBy(xpath="//input[@value=' Next ']")
	WebElement nextBtn;
	
	@FindBy(xpath="//input[@value=' Merge ']")
	WebElement mergeBtn;
	
	@FindBy(xpath="//a[contains(text(),'> 30 days')]")
	WebElement reportLink;
	
	@FindBy(name="dateColumn")
	WebElement dateField;
	
	@FindBy(xpath="//div[contains(text(),'Created Date')]")
	WebElement dateFieldOption;
	
	@FindBy(xpath="//input[@name='startDate']/following-sibling::img")
	WebElement startDateimg;
	
	@FindBy(xpath="//button[contains(text(),'Today')]")
	WebElement startDateMonthandYear;
	
	@FindBy(xpath="//a[@title='Next Month (Control+Right)']")
	WebElement rightArrow;
	
	@FindBy(xpath="//input[@name='endDate']/following-sibling::img")
	WebElement endDateimg;
	
	@FindBy(name="endDate")
	WebElement endDateMonthAndYear;
	
	@FindBy(xpath="//input[@name='startDate']")
	WebElement startDate;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement mergeReportsaveBtn;
	
	@FindBy(id="saveReportDlg_reportNameField")
		WebElement reportName;
	
	@FindBy(id="saveReportDlg_DeveloperName")
	WebElement reportUniqueName;
	
	@FindBy(id="dlgSaveAndRun")
	WebElement saveAndRunreport;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement reportsaveBtn;
	
	
	public void clickAccountTab() {
		waitForElement(10,accountTab);
		accountTab.click();
	}
	
	public void clicknewAccountBtn() {
		waitForElement(10,newAccntBtn);
		newAccntBtn.click();
	}
	
	public WebElement gettype() {
		return typeDD;
	}
	
	public WebElement getaccountName() {
		waitForElement(10,accountName);
		return accountName;
	}
	
	public WebElement getcustomerPriority() {
		return customerPriority;
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	public void clickcreatenewviewBtn() {
		waitForElement(10,createnewviewBtn);
		createnewviewBtn.click();
	}
	
	public WebElement getViewname() {
		waitForElement(10, viewname);
		viewname.clear();
		return viewname;
	}
	
	public WebElement getViewuniquename() {
		
		viewUniquename.clear();
		return viewUniquename;
	}
	
	public void clickcreatenewviewsaveBtn() {
		createnewviewsaveBtn.click();
	}
	
	public WebElement getviewNameDD() {
		waitForElement(10, viewNameDD);
		return viewNameDD;
	}
	
	public void clickEditBtn() {
		waitForElement(10, editBtn);
		editBtn.click();
	}
	
	public void clickeditSaveBtn() {
		waitForElement(10, editSaveBtn);
		editSaveBtn.click();
	}
	
	public void clickMergeAccount() {
		mergeAccountLink.click();
	}
	
		
	public WebElement getReportsLink() {
		waitForElement(10, gotoReportsLink);
		return gotoReportsLink;
	}
	
	public WebElement getmergeAccountId() {
		waitForElement(10, mergeAccountId);
		return mergeAccountId;
	}
	
	public void clickFindAccountBtn() {
		findAccountBtn.click();
	}
	
	public List<WebElement> getAccountOption(){
			return accountOptions;
	}
	
	public void clickmergeBtn() {
		mergeBtn.click();
	}
	
	public void clickNext() {
		nextBtn.click();
	}
	
	public void clickdateField() {
		waitForElement(10,dateField);
		dateField.click();
	}
	
	public void clickreportLink() {
		waitForElement(10, reportLink);
		reportLink.click();
	}
		
	public WebElement getcreatedDateOption() {
		waitForElement(10, dateFieldOption);
		return dateFieldOption;
	}
	
	public void clickstartDate() {
		startDateimg.click();
	}
	
	public void clickDateMonthandYear() {
		waitForElement(10, startDateMonthandYear);
		if(startDateMonthandYear.isDisplayed())
		startDateMonthandYear.click();
	}
	
	public WebElement getrightArrow() {
		waitForElement(10, rightArrow);
		return rightArrow;
	}
	
	public void clickendDateimg() {
		waitForElement(10, endDateimg);
		endDateimg.click();
	}
	
	public WebElement getstartDateMonthandYear() {
		return startDateMonthandYear;
	}
	
	public WebElement getendDateMonthAndYear() {
		waitForElement(10,endDateMonthAndYear);
		endDateMonthAndYear.clear();
		return endDateMonthAndYear;
	}
	
	public WebElement clickrightarrow() {
		return rightArrow;
	}
	
	public WebElement getStartDate() {
		waitForElement(10,startDate);
		startDate.clear();
		return startDate;
	}
	
	public void clickmergeReportsaveBtn() {
		waitForElement(10,mergeReportsaveBtn);
		mergeReportsaveBtn.click();
	}
	
	public WebElement getreporttNameField() {
		return reportName;
	}
	
	public WebElement getReportUniqueName() {
		return reportUniqueName;
	}
	
	public void clicksaveAndrunreport() {
		waitForElement(10, saveAndRunreport);
		saveAndRunreport.click();
	}
	
	public WebElement getSAveAndRunReport() {
		return saveAndRunreport;
	}
	
	public void clickreportSaveBtn() {
		reportsaveBtn.click();
	}
	
}
