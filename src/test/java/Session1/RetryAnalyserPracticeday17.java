package Session1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPracticeday17 {

	
	@Test(retryAnalyzer = GenericUtilities.Day17RetryAnalyserImplementation.class)
	public void sample()
	{
		//Assert.fail();
		System.out.println("hello");
	}
}
