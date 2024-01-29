package Session1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day3DDTexamples {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*//Read the data
        //Read the required data 
		//read common data from property files
        FileInputStream filei=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prope=new Properties();
		prope.load(filei);
		String URL = prope.getProperty("url");
		String USERNAME=prope.getProperty("username");
		String PASSWORD=prope.getProperty("password");
		
		//Read test data from excel file
		FileInputStream filein=new FileInputStream(".\\src\\test\\resources\\contacttestdata.xlsx");
		Workbook workb=WorkbookFactory.create(filein);
		String LASTNAME = workb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		//step 1:launch the browser
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        //step 2:load the url
        driver.get(URL);
        
        //step 3:login to application
        driver.findElement(By.name("user_name")).sendKeys( USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD );
        driver.findElement(By.id("submitButton")).click();
        
        //step 4:navigate to contact link
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        
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
        Actions actio=new Actions(driver); 
        actio.moveToElement(eleme).perform();
        
        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
        
        //step 10:close the browser
        driver.quit();*/
		
		
		//Write the data 
		FileInputStream filein=new FileInputStream(".\\src\\test\\resources\\contacttestdata.xlsx");
		Workbook workb=WorkbookFactory.create(filein);
		Sheet sh = workb.getSheet("Sheet1");
		//sh.createRow(1).createCell(2).setCellValue("Spiderman");
		sh.createRow(1).createCell(1).setCellValue("CreateContactWithMandatoryDetails");
		//sh.createRow(1).createCell(0).setCellValue("TC_01");
		
		FileOutputStream fileo=new FileOutputStream(".\\src\\test\\resources\\contacttestdata.xlsx");
		workb.write(fileo);
		workb.close();

		//FileInputStream fileinp=new FileInputStream(".\\src\\test\\resources\\contacttestdata.xlsx");
		//Workbook workbo=WorkbookFactory.create(fileinp);
		//String data= workbo.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		//System.out.println(data);
		
	}

}
