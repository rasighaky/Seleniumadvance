package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser interface to TestNG
 * @author kymon
 *
 */
public class Day17RetryAnalyserImplementation implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
		
		int count=0;
		int retrycount=3;
		
		//0<3 1<3 2<3 3<3
		while(count<retrycount)
		{
			count++;// 1 2 3 
			return true;//retry retry retry
		}
		
		return false; //stop  retry
	}

}
