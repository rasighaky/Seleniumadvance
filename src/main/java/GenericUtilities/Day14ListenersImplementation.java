package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation to ITestListener interface of testNG 
 * @author kymon
 *
 */
public class Day14ListenersImplementation  implements ITestListener{

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//start of @test -test method
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----- Test execution started -----");
		
		//provide the @test to for extent reports
		test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----- Test pass -----");
		
		//log the status as pASS in extent reports
		test.log(Status.PASS,methodName+"----- Test pass -----");
	
	
	}

	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----- Test fail -----");
		
		//print the exception in console
	    System.out.println(result.getThrowable());
	    
	    //log the status as FAIL in extent reports
	    test.log(Status.FAIL,methodName+"----- Test fail -----");
	    test.log(Status.INFO,result.getThrowable());
        
	    //capture the screenshot
	    Day4SeleniumUtility s=new Day4SeleniumUtility();
	    Day5DateUtility j=new Day5DateUtility();
	     
	    String screenShotName=methodName+"-"+j.getSystemDate();
	    try {
			String path = s.captureScreenShot(Day10BaseClass.sDriver, screenShotName);
			
			//attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"----- Test skip -----");
		
		//print the exception in console
		System.out.println(result.getThrowable());
		
		//log the status as SKIP in extent report
		test.log(Status.SKIP,methodName+"----- Test skip -----");
		test.log(Status.INFO,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("----- Suite Execution Started -----");
		
		//basic configuration of extent reports
        ExtentSparkReporter rep=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new Day5DateUtility().getSystemDate()+".html");
	    rep.config().setDocumentTitle("Execution Report");
	    rep.config().setTheme(Theme.DARK);
	    rep.config().setReportName("Vtiger execution report");
	    
	    //attach the configuration to actual extentreports class
	    report =new ExtentReports();
	    report.attachReporter(rep);
	    
	    //set any system information
	    report.setSystemInfo("Base Platform", "Windows");
	    report.setSystemInfo("Base Browser", "Chrome");
	    report.setSystemInfo("Base Environment", "Testing");
	    report.setSystemInfo("Reporter Name", "Rasigha");
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("----- Suite Execution finished -----");
		
		//generate the report
		report.flush();
	}
	
}
