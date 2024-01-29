package Session1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17RetryAnalyserpractice {

	
	@Test(retryAnalyzer = GenericUtilities.Day17RetryAnalyserImplementation.class)
	public void sample()
	{
	   //Assert.fail();
	   System.out.println("hello");
	}
	

}
