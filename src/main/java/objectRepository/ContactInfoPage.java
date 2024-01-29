package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
  @FindBy(xpath="//span[@class='dvHeaderText']")
  private WebElement contactheader;
  
  public ContactInfoPage(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }

  public WebElement getContactheader() {
	return contactheader;
  }
  
  /** 
   * This method will capture hadertext and return it to caller
   * @return
   */
  public String captureHeaderText()
  {
	return contactheader.getText();
  }
}
