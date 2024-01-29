package Session1;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day8sampletestng {
/** @Test(invocationCount=3,priority=-1)  //invocationcount cannot be zero if we give zero its equal to disable,priority can start from negative
 public void createcustomer()
 {
	 System.out.println("create");
 }
 @Test
 public void Modifycustomer()
 {
	 System.out.println("modify");
 }
 @Test
 public void Deletecustomer()
 {
	 System.out.println("delete");
 }*/
	 @Test   //(enabled=false)
	 public void createcustomer()
	 {
		 Assert.fail();
		 System.out.println("create");
	 }
	 @Test(dependsOnMethods="createcustomer")
	 public void Modifycustomer()
	 {
		 System.out.println("modify");
	 }
	 @Test
	 public void Deletecustomer()
	 {
		 System.out.println("delete");
	 }
}
