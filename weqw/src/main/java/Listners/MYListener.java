package Listners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MYListener implements ITestListener,ISuiteListener {
	
	
	 public void onStart(ITestContext context) {
		    // not implemented
		 System.out.println("started");
		 Date datee=new Date();
		 SimpleDateFormat dates=new SimpleDateFormat("HH-mm-ss");	
		 String Time = dates.format(datee);
		 System.out.println(Time);
		
		  }
	 public void onTestStart(ITestResult result) {
		    // not implemented
		  }
	
	 public void onTestSuccess(ITestResult result) {
		 
		    // not implemented
		  }
	 public void onTestFailure(ITestResult result) {
		    // not implemented
		  }
	 public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }
	 
	 public void onFinish(ITestContext context) {
		    // not implemented
		 System.out.println("Finished");
		 Date datee=new Date();
		 SimpleDateFormat dates=new SimpleDateFormat("HH-mm-ss");	
		 String Time = dates.format(datee);
		 System.out.println(Time);

		  }
	
}
 