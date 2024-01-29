package Session1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day11Assertionpractice {
 @Test
 public void sample()
{
	 String a="hello";
	 System.out.println("Step 1");
	 System.out.println("Step 2");
	 System.out.println("Step 3");
	 
	 //Assert.assertEquals(1, 1); //pass
	 //Assert.assertEquals(0, 1); //fail
	 
	 //Assert.assertTrue(a.contains("o")); //pass
	 Assert.assertTrue(a.contains("a"));   //fail
	 
	 System.out.println("Step 4");
	 System.out.println("Step 5");
	 
	 
	 }
 
 @Test
 public void sample1()
{
	 SoftAssert sa=new SoftAssert();
	 String a="hello";
	 System.out.println("Step 1");
	 System.out.println("Step 2");
	 System.out.println("Step 3");
	 
	 //sa.assertEquals(1, 1); //pass
	 sa.assertEquals(0, 1); //fail
	 
	 //sa.assertTrue(a.contains("o")); //pass
	 sa.assertTrue(a.contains("a"));   //fail
	 
	 System.out.println("Step 4");
	 System.out.println("Step 5");
	 sa.assertAll();
	 
	 }
}
