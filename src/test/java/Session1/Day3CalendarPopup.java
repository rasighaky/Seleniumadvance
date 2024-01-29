package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GenericUtilities.Day4SeleniumUtility;
import GenericUtilities.Day5DateUtility;

public class Day3CalendarPopup {

	
	Day4SeleniumUtility sUtil=new Day4SeleniumUtility();
    Day5DateUtility jUtil=new Day5DateUtility();
   
    
	
	@Test
	public void scenario1()
	{
		
		//driver.get("https://www.makemytrip.com/ ");
		WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitWait(driver);
		driver.get("https://www.goibibo.com/");
		
		//driver.findElement(By.xpath("//a[@class='close']")).click();
		
		//Actions acti=new Actions(driver);
		//acti.moveByOffset(20, 30).perform();
		
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Jan 25 2024']")).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.quit();
	}
	
	@Test
	public void scenario3()
	{
		WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitWait(driver);
		driver.get("https://www.goibibo.com/");
		String date=jUtil.getSystemDate();
		String[] tdate=date.split("_");
		System.out.println(tdate[0]);
		
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String todaydate=tdate[0];
		driver.findElement(By.xpath(todaydate));
		
		
	}
	
}
