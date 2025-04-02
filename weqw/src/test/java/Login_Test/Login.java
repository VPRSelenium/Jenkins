package Login_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import BaseClass.Baseclass;
import ObjectRepositary.Loginpage;
import UtilityProperites.FileUtilities;
import UtilityProperites.WebDriveruti;
import dev.failsafe.internal.util.Assert;

//@Listeners(Listners.MYListener.class)-without xm; file
public class Login extends Baseclass {
   // @Parameters("browser")
	//@Test(groups= {"IntegrationTest"})
	@Test(priority=2,invocationCount=0, threadPoolSize=2,groups= {"RegressionTest"})
	public  void Login() throws IOException, ParseException  {
		// TODO Auto-generated method stub
		
    	
    //	String Browser=browser;
		WebDriveruti webutil=new WebDriveruti();
		FileUtilities file=new FileUtilities();
		
		    webutil.Maximize(sdriver);
		    String CurrentUrl = sdriver.getCurrentUrl();
		    String ActualURl = "http://49.249.28.218:8098/";
				  
		  assertEquals(ActualURl, CurrentUrl);
		  assertEquals(ActualURl, CurrentUrl, "Validatio is failed");
		  Reporter.log("Entered into Dashboard Screen",true);

		  /*
		  if(CurrentUrl.equals(ActualURl))
		  {
		    Reporter.log("Entered into Dashboard Screen",true);
		    
		  }
		  else
		  {
			  Reporter.log("Not Entered into Dashboard Screen",true);

		  } 
		  driver.close();
		   
		    *
		    */
		  
		  // create verification for all testcase 
		  // create product test case 
		  // create assert methods
		  //complete this by tomorrow
	}

}
 