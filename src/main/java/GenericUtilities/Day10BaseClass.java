package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.LoggingAssert;

import objectRepository.HomePage;
import objectRepository.LoginPage;
/**
 * 
 * @author kymon
 *
 */

public class Day10BaseClass {
    
	public Day4ExcelfileUtility eUtil=new Day4ExcelfileUtility();
    public Day4PropertyfileUtility pUtil=new Day4PropertyfileUtility();
    public Day4SeleniumUtility sUtil=new Day4SeleniumUtility();
    public Day5DateUtility jUtil=new Day5DateUtility();
    
    public WebDriver driver;
    
    //for listeners
    public static WebDriver sDriver;
    
    @BeforeSuite(alwaysRun = true)  //add testng library and import before suite
    public void bsConfig()
    {
    	System.out.println("======DB connection successful=====");
    }
    
   
    
    //using cross browser execution
   /* @Parameters("Browser")
    @BeforeTest
    public void bcConfig(String BROWSER) throws IOException
    {
    	String URL = pUtil.readDataFromUtilityFile("url");
    	
    	if(BROWSER.equals("chrome"))
    	{
    	driver=new ChromeDriver();
    	}
    	else if(BROWSER.equals("edge"))
    	{
    		driver=new EdgeDriver();
    	}
    	
    	
    	sUtil.maximizeWindow(driver);
    	sUtil.addImplicitWait(driver);
    	
    	driver.get(URL);
    	
    	System.out.println("====== Browser launch successful=====");
    }*/
    
   //@BeforeTest
    @BeforeClass(groups={"SmokeSuite","RegressionSuite"})                //(groups="SmokeSuite")
    public void bcConfig() throws IOException
    {
    	String URL = pUtil.readDataFromUtilityFile("url");
    	
    	driver=new ChromeDriver();
    	
    	
    	sUtil.maximizeWindow(driver);
    	sUtil.addImplicitWait(driver);
    	
    	driver.get(URL);
    	
    	System.out.println("====== Browser launch successful=====");
    	
    	sDriver=driver;
    }
    
    @BeforeMethod(alwaysRun = true)
    public void bmConfig() throws IOException
    {
    	String USERNAME = pUtil.readDataFromUtilityFile("username");
    	String PASSWORD = pUtil.readDataFromUtilityFile("password");
    	
    	LoginPage lp=new LoginPage(driver);
    	lp.loginToApp(USERNAME, PASSWORD);
    	
    	System.out.println("====== Login to app successful=====");
    }
    
    @AfterMethod(alwaysRun = true)
    public void amConfig() throws InterruptedException
    {
    	HomePage hp=new HomePage(driver);
    	hp.logoutOfApp(driver);
    	
    	System.out.println("====== Logout of app successful=====");
    }
    
   
    @AfterTest
   // @AfterClass(alwaysRun = true)
    public void acConfig()
    {
    	driver.quit();
    	
    	System.out.println("====== Browser closure successful=====");
    }
    
    @AfterSuite(alwaysRun = true)
    public void asConfig()
    {
    	System.out.println("======DB closure successful=====");
    }
}
