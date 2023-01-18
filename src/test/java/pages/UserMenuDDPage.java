package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class UserMenuDDPage extends BasePage{
	
	@FindBy(id="userNavLabel")
	WebElement userMenuDD;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	@FindBy(xpath="//a[@title='My Profile']")
	WebElement myProfileLink;
	
	@FindBy(xpath="//a[@title='My Settings']")
	WebElement mySettingLink;
	
	@FindBy(id="PersonalInfo_font")
	WebElement personalLink;
	
	@FindBy(id="LoginHistory_font")
	WebElement loginHistoryLink;
	
	@FindBy(xpath="//a[@title='Switch to Lightning Experience']")
	WebElement switchToLightningExpLink;
	
	@FindBy(xpath="//a[contains(text(),'Download login history for last six months, includ')]")
	WebElement downLoadLink;
	
	@FindBy(xpath="//a[contains(text(),'Developer Console')]")
	WebElement developerConsole;
	
	@FindBy(id="chatterTab")
	WebElement profileTab;
	
	@FindBy(xpath="//*[contains(text(),'Contact')]//*[@title='Edit Profile']")
	WebElement editContact;
	
	@FindBy(id="contactInfoContentId")
	WebElement editFrameElement;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement aboutTab;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//input[@value='Save All']")
	WebElement saveAll;
	
	@FindBy(id="publisherAttachTextPost")
	WebElement postLink;
	
	@FindBy(xpath="//div[@role='presentation']/iframe")
	WebElement textareaFrame;
	
	@FindBy(xpath="/html/body")
	WebElement textarea;
	
	@FindBy(id="publishersharebutton")
	WebElement shareButton;
	
	@FindBy(xpath="//a[@id='publisherAttachContentPost']")
	WebElement fileLink;
	
	@FindBy(id="chatterUploadFileAction")
	WebElement fileUpload;
	
	@FindBy(id="chatterUploadFileAction")
	WebElement uploadFromComputerButton;
	
	@FindBy(id="chatterFile")
	WebElement chooseFile;
	
	@FindBy(id="displayBadge")
	WebElement moderatorText;
	
	@FindBy(xpath="//a[@id='uploadLink']")
	WebElement addPhotoLink;
	
	@FindBy(id="uploadPhotoContentId")
	WebElement uploadPhotoFrame;
	
	@FindBy(xpath="//input[contains(@id,'uploadInputFile')]")
	WebElement choosePhoto;
	
	@FindBy(id="DisplayAndLayout_font")
	WebElement displayAndLayout;
	
	@FindBy(id="CustomizeTabs_font")
	WebElement customizeTab;
	
	@FindBy(name="save")
	WebElement saveButton;
	
	@FindBy(id="p4")
	WebElement customAppDD;
	
	@FindBy(id="duel_select_0")
	WebElement availableTabs;
	
	@FindBy(id="duel_select_0_right")
	WebElement addTab;
	
	@FindBy(xpath="//*[@title='Down']")
	WebElement downArrow;
	
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@name='save']")
	WebElement bottomSaveBtn;
	
	@FindBy(id="EmailSetup_font")
	WebElement emailSetup;
	
	@FindBy(id="EmailSettings_font")
	WebElement myEmailSettings;
	
	@FindBy(id="sender_name")
	WebElement emailNameField;
	
	@FindBy(id="sender_email")
	WebElement emailIdField;
	
	@FindBy(id="auto_bcc1")
	WebElement autoBcccheck;
	
	@FindBy(id="CalendarAndReminders_font")
	WebElement calendarsAndremainder;
	
	@FindBy(id="Reminders_font")
	WebElement activityRemainder;
	
	@FindBy(id="testbtn")
	WebElement openTestRemainderBtn;
	
		
	public UserMenuDDPage(WebDriver driver) {
		 super(driver);
	 }
	
	public void logoutUser(UserMenuDDPage userMenuDDPage) {
		userMenuDD.click();
		logoutLink.click();
	}
	
	public void clickMyProfileLink() {
		waitForElement(10,myProfileLink);
		myProfileLink.click();
	
	}
	
	public void clickMySettingsLink() {
		waitForElement(10,mySettingLink);
		mySettingLink.click();
	
	}
	
	public void clickPersonalLink() {
		waitForElement(10,personalLink);
		personalLink.click();
	
	}
	
	public void clickloginHistoryLink() {
		waitForElement(10,loginHistoryLink);
		loginHistoryLink.click();
	
	}
	
	public void clickdownLoadLink() {
		waitForElement(10,downLoadLink);
		downLoadLink.click();
	
	}
	
	public WebElement getmyProfileLink() {
		return myProfileLink;
	}
	
	public WebElement getMySettingsLink() {
		return mySettingLink;
	}
	public WebElement getlogoutLink() {
		return logoutLink;
	}
	public WebElement getswitchToLightningExpLink() {
		return switchToLightningExpLink;
	}
	
	public WebElement getdeveloperConsoleLink() {
		return developerConsole;
	}
	
	public WebElement getprofileTabLink() {
		return profileTab;
	}
	
	public void clickEditContactLink() {
		waitForElement(10,editContact);
		editContact.click();
	}
	
	public void switchToEditContactFrame() {
		waitForElement(10,editFrameElement);
		driver.switchTo().frame(editFrameElement);
	}
	
	public void clickAboutTab() {
		aboutTab.click();
	}
	
	public WebElement getLastNameField() {		
		lastName.clear();
		return lastName;
	}
	
	public void clickSaveAll() {
		saveAll.click();
	}
	
	public void clickPostLink() {
		waitForElement(10,postLink);
		postLink.click();
	}
	
	public WebElement gettextareaFrame() {
		return textareaFrame;
	}
	
	public WebElement clickTextArea() {
		waitForElement(10,textarea);
		textarea.click();
		return textarea;
	}
	
	public void clicksharebutton() {
		shareButton.click();
	}
	
	public void clickFileLink() {
		waitForElement(10,fileLink);
		fileLink.click();
	}
	
	public void clickuploadFromComputerButton() {
		uploadFromComputerButton.click();
	}
	
	public WebElement chooseFileButton() {
		return chooseFile;
	}
	
	public WebElement moderatorText() {
		return moderatorText;
		
	}
	
	public WebElement getAddPhotoLink() {
		return addPhotoLink;
	}
	
	public WebElement getuploadPhotoFrame() {
		return uploadPhotoFrame;
	}
	
	public WebElement getChoosePhoto() {
		return choosePhoto;
	}
	
	public WebElement getdisplayAndLayout() {
		return displayAndLayout;
	}
	
	public void clickDisplayAndLayout() {
		displayAndLayout.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public WebElement getsaveButton() {
		return saveButton;
	}
	
	public void clickCustomizeTab() {
		customizeTab.click();
	}
	
	public Select selectCustomAppDD() {
		Select customDD = new Select(customAppDD);
		return customDD;		
		
	}
	
	public void clickAddTab() {
		addTab.click();
	}
	
	public Select selectgetAvailableTabs() {
		Select availableTab = new Select(availableTabs);
		return availableTab;
	}
	
	public void clickDownArrow() {
		downArrow.click();
	}
	
	public void clickBottomSaveBtn() {
		bottomSaveBtn.click();
	}
	
	public void clickmyEmailSettings() {
		myEmailSettings.click();
	}
	
	public void clickEmail() {
		emailSetup.click();
	}
	
	public WebElement getemailNameField() {
		emailNameField.clear();
		return emailNameField;
	}
	
	public WebElement getemailIdField() {
		emailIdField.clear();
		return emailIdField;
	}
	
	public void clickAutoBcc() {
		autoBcccheck.click();
	}
	
	public void clickcalendarAndremainder() {
		calendarsAndremainder.click();
	}
	
	public void clickActivityRemainder() {
		activityRemainder.click();
	}
	
	public void clickOpenTestRemainder() {
		openTestRemainderBtn.click();
	}
	
	public void clickDeveloperConsole() {
		developerConsole.click();
	}
	
	
}
