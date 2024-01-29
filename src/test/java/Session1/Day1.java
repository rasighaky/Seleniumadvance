package Session1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Day1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step 1:launch the browser
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        //step 2:load the url
        driver.get("http://localhost:8888");
        
        //step 3:login to application
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        
        //step 4:navigate to contact link
        driver.findElement(By.xpath("//a[text()='Contacts']")).click();
        
        //step 5:click on create contact lookup image
        driver.findElement(By.xpath("//img[contains(@title,'Create Contact')]")).click();
        
        //step 6:create a new contact with mandatory details
        driver.findElement(By.name("lastname")).sendKeys("asdfg");
        
        //step 7:save
        driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
        
        //step 8:validate
        
        String conheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(conheader.contains("asdfg"))
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
        driver.quit();
	}

}
