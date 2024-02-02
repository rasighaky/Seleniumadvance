package contactsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.Day10BaseClass;
import GenericUtilities.Day4ExcelfileUtility;
import GenericUtilities.Day4PropertyfileUtility;
import GenericUtilities.Day4SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(GenericUtilities.Day14ListenersImplementation.class)
public class CreateNewContactsTest extends Day10BaseClass {
	
	//after using base class
	
	//for listeners implementation test fail
	@Test
	public void sample()
	{
		//Assert.fail();
		System.out.println(" sample method");
	}
	//@Test(groups="SmokeSuite",dependsOnMethods="sample")
	
    @Test(groups="SmokeSuite")  
	public void createNewContact() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
      	
		//Read test data from excel file
		
		String LASTNAME = eUtil.readDataFromExcel(4, 2);
		
       
        //step 4:navigate to contact link
       HomePage hp=new HomePage(driver);
       hp.clickOnContactsLink();
      
        
        //step 5:click on create contact lookup image
       ContactsPage cp=new ContactsPage(driver);
       cp.clickOnCreateContactLookUpImg();
      
       
        //step 6:create a new contact with mandatory details
       CreateNewContactPage cncp=new CreateNewContactPage(driver);
       cncp.createNewContact(LASTNAME);
        
        
        //step :validate
        
        ContactInfoPage cip=new ContactInfoPage(driver);
        String conheader = cip.captureHeaderText();
        /*if(conheader.contains(LASTNAME))
        {
      	  System.out.println("pass");
      	  System.out.println(conheader);
        }
        else
        {
      	  System.out.println("fail");
        }*/
        
        Assert.assertTrue(conheader.contains(LASTNAME));
        System.out.println(conheader);
        
	}
    @Test
    public void sample1()
    {
    	System.out.println("hello");
    	System.out.println("world");
    }
	
	/* //before base class
	  
	 @Test
	public void createNewContact() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

       Day4ExcelfileUtility eUtil=new Day4ExcelfileUtility();
        Day4PropertyfileUtility pUtil=new Day4PropertyfileUtility();
        Day4SeleniumUtility sUtil=new Day4SeleniumUtility();
        
        //Read the required data 
		//read common data from property files
       
		String URL = pUtil.readDataFromUtilityFile("url");
		String USERNAME=pUtil.readDataFromUtilityFile("username");
		String PASSWORD=pUtil.readDataFromUtilityFile("password");
		
		//Read test data from excel file
		
		String LASTNAME = eUtil.readDataFromExcel(4, 2);
		
		//step 1:launch the browser
        WebDriver driver=new ChromeDriver();
       sUtil.addImplicitWait(driver);
       sUtil.maximizeWindow(driver);
        
        //step 2:load the url
        driver.get(URL);
        
        //step 3:login to application
        
        LoginPage lp=new LoginPage(driver);
        lp.loginToApp(USERNAME, PASSWORD);
        
        //step 4:navigate to contact link
       HomePage hp=new HomePage(driver);
       hp.clickOnContactsLink();
        
        //step 5:click on create contact lookup image
       ContactsPage cp=new ContactsPage(driver);
       cp.clickOnCreateContactLookUpImg();
       
        //step 6:create a new contact with mandatory details
       CreateNewContactPage cncp=new CreateNewContactPage(driver);
       cncp.createNewContact(LASTNAME);
        
        
        //step :validate
        
        ContactInfoPage cip=new ContactInfoPage(driver);
        String conheader = cip.captureHeaderText();
        if(conheader.contains(LASTNAME))
        {
      	  System.out.println("pass");
      	  System.out.println(conheader);
        }
        else
        {
      	  System.out.println("fail");
        }
        
        //step 9:logout
        hp.logoutOfApp(driver);
        
        //step 10:close the browser
        driver.quit();

	}*/

}

   