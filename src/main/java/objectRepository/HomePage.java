package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.Day4SeleniumUtility;

public class HomePage extends Day4SeleniumUtility {
    @FindBy(xpath = "//a[text()='Contacts']")
    private WebElement contactsLnk;
    
   // @FindBy(xpath="(//td[@valign='bottom'])[2]")
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement adminImg;
    
    @FindBy(xpath="//a[text()='Sign Out']")
    private WebElement signoutLnk;
    
    public HomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }

	public WebElement getContactslink() {
		return contactsLnk;
	}

	public WebElement getAdminimg() {
		return adminImg;
	}

	public WebElement getSignoutlink() {
		return signoutLnk;
	}
    
	//business library
	/**
	 * This method will click on contacts link
	 */
     public void clickOnContactsLink()
     {
    	 contactsLnk.click();
     }
     
     /**
      * This method will logout of application
      * @param driver
      * @throws InterruptedException
      */
     public void logoutOfApp(WebDriver driver) throws InterruptedException
     {
    	 mouseOverAction(driver, adminImg);
    	 Thread.sleep(1000);
    	 signoutLnk.click();
     }
}
