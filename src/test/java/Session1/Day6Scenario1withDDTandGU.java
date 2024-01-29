package Session1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.Day4ExcelfileUtility;
import GenericUtilities.Day4PropertyfileUtility;
import GenericUtilities.Day4SeleniumUtility;
import objectRepository.LoginPage;

public class Day6Scenario1withDDTandGU {

	public static void main(String[] args) throws IOException {
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
				
				String LASTNAME = eUtil.readDataFromExcel(4, 3);
				
				//step 1:launch the browser
		        WebDriver driver=new ChromeDriver();
		       sUtil.addImplicitWait(driver);
		       sUtil.maximizeWindow(driver);
		        
		        //step 2:load the url
		        driver.get(URL);
		        
		        //step 3:login to application
		       /* driver.findElement(By.name("user_name")).sendKeys( USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
		        driver.findElement(By.id("submitButton")).click();*/
		        
		            //using pom class
		        LoginPage lp=new LoginPage(driver);
		        
		        //lp.getUsernameEdt().sendKeys(USERNAME);
		        //lp.getPasswordEdt().sendKeys(PASSWORD);
		        //lp.getLoginBtn().click();
		        
		          //using business library
		        lp.loginToApp(USERNAME, PASSWORD);
		        
		        //step 4:navigate to contact link
		      /*  driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		        
		        //step 5:click on create contact lookup image
		        driver.findElement(By.xpath("//img[contains(@title,'Create Contact')]")).click();
		        
		        //step 6:create a new contact with mandatory details
		        driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		        
		        //step 7:save
		        driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		        
		        //step 8:validate
		        
		        String conheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
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
		        WebElement eleme = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        sUtil.mouseOverAction(driver, eleme);
		        
		        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		        
		        //step 10:close the browser
		        driver.quit();*/
	}

}
