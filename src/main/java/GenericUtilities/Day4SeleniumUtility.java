package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


//Day5SeleniumUtility

public class Day4SeleniumUtility {
	/**
	 * * This method will maximize the window
	 * @param driver
	*/
	 public void maximizeWindow(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
	 /**
	  * This method will minize the window
	  * @param driver
	  */
	 public void minizeWindow(WebDriver driver)
	 {
		 driver.manage().window().minimize();
	 }
	 /**
	  * This method will add 10s of implicit wait
	  * @param driver
	  */
	 public void addImplicitWait(WebDriver driver)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	 }
	 /**
	  * This method will wait for 10s for an element to be visible
	  * @param driver
	  * @param element
	  */
	 public void waitForElementToVisible(WebDriver driver,WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 /**
	  * This method will handle dropdown by index
	  * @param element
	  * @param index
	  */
	 public void handleDropdown(WebElement element ,int index)
	 {
		 Select se=new Select(element);
		 se.selectByIndex(index);
	 }
	 /**
	  * this method will handle dropdown by value
	  * @param element
	  * @param value
	  */
	 public void handleDropdown(WebElement element ,String value)
	 {
		 Select se=new Select(element);
		 se.selectByValue(value);
	 }
	 /**
	  * This method will handle dropdown by visibletext
	  * @param text
	  * @param element
	  */
	 public void handleDropdown(String text,WebElement element)
	 {
		 Select se=new Select(element);
		 se.selectByVisibleText(text);
	 }
	 /**
	  * This method will perform mouse over action on a web element
	  * @param driver
	  * @param element
	  */
	 public void mouseOverAction(WebDriver driver,WebElement element)
	 {
		 Actions actio=new Actions(driver);
		 actio.moveToElement(element).perform();
		 
	 }
	 /**
	  * This method will perform right click on a web element
	  * @param driver
	  * @param element
	  */
	 public void rightClick(WebDriver driver,WebElement element)
	 {
		 Actions  actio=new Actions(driver);
		 actio.contextClick(element).perform();
	 }
	 /**
	  * This menthod will perform doubleclick on a web element
	  * @param driver
	  * @param element
	  */
	 public void doubleClick(WebDriver driver,WebElement element)
	 {
		 Actions  actio=new Actions(driver);
		 actio.doubleClick(element).perform();
	 }
	 /**
	  * This method will perform drag and drop operation
	  * @param driver
	  * @param src
	  * @param target
	  */
	  public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
	  {
		  Actions actio=new Actions(driver);
		  actio.dragAndDrop(src, target).perform();
	  }
	  /**
	   * This method will scroll down the page for 500 units
	   * @param driver
	   */
	  public void scrollDownAction(WebDriver driver)
	  {
		  JavascriptExecutor jr=(JavascriptExecutor) driver;
		  jr.executeScript("Window.scrollBy(0,500);"," ");
	  }
	  /**
	   * This method will scroll up the page for 500 units
	   * @param driver
	   */
	  public void scrollUpAction(WebDriver driver)
	  {
		  JavascriptExecutor jr=(JavascriptExecutor) driver;
		  jr.executeScript("Window.scrollBy(0,-500);"," ");
	  }
	  /**
	   * This method will scroll right the page for 500 units
	   * @param driver
	   */
	  public void scrollRightAction(WebDriver driver)
	  {
		  JavascriptExecutor jr=(JavascriptExecutor) driver;
		  jr.executeScript("Window.scrollBy(500,0);"," ");
	  }
	  /**
	   * This method will scroll left the page for 500 units
	   * @param driver
	   */
	  public void scrollLeftAction(WebDriver driver)
	  {
		  JavascriptExecutor jr=(JavascriptExecutor) driver;
		  jr.executeScript("Window.scrollBy(-500,0);"," ");
	  }
	  /**
	   * This method will handle frame using frame Index
	   * @param driver
	   * @param frameindex
	   */
	  public void handleFrame(WebDriver driver,int frameIndex)
	  {
		  driver.switchTo().frame(frameIndex);
	  }
	  /**
	   * This method will handle frame using frame Name or Id
	   * @param driver
	   * @param frameindex
	   */
	  public void handleFrame(WebDriver driver,String frameNameOrId)
	  {
		  driver.switchTo().frame(frameNameOrId);
	  }
	  /**
	   * This method will handle frame using frame Web Element
	   * @param driver
	   * @param frameindex
	   */
	  public void handleFrame(WebDriver driver,WebElement frameElement)
	  {
		  driver.switchTo().frame(frameElement);
	  }
	  
	  /**
	   * This method will accept the alert popup
	   * @param driver
	   */
	  public void acceptAlert(WebDriver driver)
	  {
		  driver.switchTo().alert().accept();
	  }
	  
	  /**
	   * This method will cancel the alert popup
	   * @param driver
	   */
	  public void cancelAlert(WebDriver driver)
	  {
		  driver.switchTo().alert().dismiss();
	  }
	  /**
	   * This method will capture the alert text and return it to  caller
	   * @param driver
	   */
	  public String getAlertText(WebDriver driver)
	  {
		  return driver.switchTo().alert().getText();
	  }
	  
	  /**
	   * This method will capture the screenshot and return the path to caller
	   * @param driver
	   * @param screenShotName
	   * @return
	   * @throws IOException
	   */
	  public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	  {
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
		  Files.copy(src, dst);
		  
		  return dst.getAbsolutePath();
	  }

}
