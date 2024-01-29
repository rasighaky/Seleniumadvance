package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.Day4SeleniumUtility;

public class CreateNewContactPage extends Day4SeleniumUtility{
     @FindBy(name="lastname")
     private WebElement lastnameEdt;
     
     @FindBy(xpath="//input[contains(@value,'Save')]")
     private WebElement saveBtn;
     
     @FindBy(name="leadsource")
     private WebElement leadsourceDropDown;
     
     public CreateNewContactPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
     }

	public WebElement getLastnameedt() {
		return lastnameEdt;
	}

	public WebElement getSavebtn() {
		return saveBtn;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}
	
	/**
	 * This method will create  new contact  with mandatory details
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create new contact with lead source drop down value
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContact(String LASTNAME,String LEADSOURCE)
	{
		lastnameEdt.sendKeys(LASTNAME);
		handleDropdown(leadsourceDropDown, LEADSOURCE);
		saveBtn.click();

	}
     
     
}
