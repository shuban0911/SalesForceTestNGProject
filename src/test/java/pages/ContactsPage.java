package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[contains(@title,'Contacts Tab')]")
	WebElement contactsTab;
	
	@FindBy(xpath = "//input[@name='new']")
	WebElement newBtn;
	
	@FindBy(xpath="//h2[contains(text(),'New Contact')]")
	WebElement newcontactPage;
	
	@FindBy(id="name_lastcon2")
	WebElement lastname;
	
	@FindBy(id="con4")
	WebElement accountName;
	
	@FindBy(name="save")
	WebElement saveBtn;
	
	@FindBy(id="con4_lkwgt")
	WebElement searchIcon;
	
	@FindBy(id="searchFrame")
	WebElement searchFrame;
	
	@FindBy(xpath="//input[@title='Go!']")
	WebElement goBtn;
	
	@FindBy(xpath="//input[@id='lksrch']")
	WebElement searchBox;
	
	@FindBy(id="resultsFrame")
	WebElement resultsFrame;
	
	@FindBy(xpath="//tr[@class='dataRow even first']//a")
	WebElement firstSearchResult;
	
	@FindBy(xpath="//h2[@class='topName']")
	WebElement contactName;
	
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement createNewView;
	
	@FindBy(id="fname")
	WebElement viewname;
	
	@FindBy(id="fcf")
	WebElement contactsDD;
	
	@FindBy(id="hotlist_mode")
	WebElement recentContactsDD;
	
	@FindBy(xpath="//table[@class='list']//tr")
	List<WebElement> newContacts;
	
	@FindBy(xpath="//tr[@class='dataRow even first']//th//a")
	WebElement newContact;
	
	@FindBy(xpath="//table[@class='list']//tr[2]//th//a")
	WebElement newContactLink;
	
	@FindBy(id="devname")
	WebElement viewUniqueName;
	
	@FindBy(xpath="//div[contains(text(),'You must enter a value')]")
	WebElement errMsg;
	
	@FindBy(name="cancel")
	WebElement cancelBtn;
	
	@FindBy(name="save_new")
	WebElement saveAndnewBtn;
	
	@FindBy(xpath="//h2[contains(text(),'Contact Edit')]")
	WebElement isEditPage;
	
	
	
	
	
	public void clickContactsTab() {
		waitForElement(10, contactsTab);
		contactsTab.click();
	}
	
	public void clickNewBtn() {
		waitForElement(10, newBtn);
		newBtn.click();
	}
	
	public WebElement getnewContactPage() {
		waitForElement(10, newcontactPage);
		return newcontactPage;
	}
	
	public WebElement getLastName() {
		waitForElement(10, lastname);
		return lastname;
	}
	
	public WebElement getaccountName() {
		waitForElement(10, accountName);
		return accountName;
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	public void clickSearchIcon() {
		searchIcon.click();
	}
	
	public WebElement getSearchFrame() {
		waitForElement(10, searchFrame);
		return searchFrame;
	}
	
	public void clickGoBtn() {
		waitForElement(10, goBtn);
		goBtn.click();
	}
	
	public WebElement getsearchBox() {
		waitForElement(10, searchBox);
		return searchBox;
	}
	
	public WebElement getResultsFrame() {
		waitForElement(10, resultsFrame);
		return resultsFrame;
	}
	
	public void clickSearchResult() {
		waitForElement(10, firstSearchResult);
		firstSearchResult.click();
	}
	
	public WebElement getContactName() {
		waitForElement(10, contactName);
		return contactName;
	}
	
	public void clickcreateNewViewLink() {
		waitForElement(10, createNewView);
		createNewView.click();
	}
	
	public WebElement getViewName() {
		waitForElement(10, viewname);
		return viewname;
	}
	
	public WebElement getContactsDD() {
		waitForElement(10, contactsDD);
		return contactsDD;
	}
	
	public WebElement getnewContact() {
		waitForElement(10, newContact);
		return newContact;
	}
	
	public WebElement getrecentContactDD() {
		waitForElement(10, recentContactsDD);
		return recentContactsDD;
	}
	
	public List<WebElement> getcontacts(){
		return newContacts;
	}
	
	public void clickAContact() {
		waitForElement(10, newContact);
		newContact.click();
	}
	
	public void clickAContactLink() {
		waitForElement(10, newContactLink);
		newContactLink.click();
	}
	
	public WebElement getUniqueViewName() {
		waitForElement(10, viewUniqueName);
		viewUniqueName.click();
		viewUniqueName.clear();
		return viewUniqueName;
	}
	
	public void clickCancelBtn() {
		waitForElement(10, cancelBtn);
		cancelBtn.click();
	}
	
	public boolean isErrorDisplayed() {
		waitForElement(10, errMsg);
		return errMsg.isDisplayed();
	}
	
	public void clickSaveAndNewBtn() {
		waitForElement(10, saveAndnewBtn);
		saveAndnewBtn.click();
	}
	
	public boolean isEditPage() {
		waitForElement(10, isEditPage);
		return isEditPage.isDisplayed();
	}
	
	

}
