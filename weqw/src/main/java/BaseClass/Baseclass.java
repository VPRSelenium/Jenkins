package BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepositary.Loginpage;
import UtilityProperites.FileUtilities;
import UtilityProperites.JavaUtilities;

import org.testng.annotations.AfterMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;

public class Baseclass {
	JavaUtilities javaa=new JavaUtilities();
	FileUtilities files=new FileUtilities();
	WebDriver driver=null;
	 public static WebDriver sdriver;

	@BeforeSuite
	
	public void beforeSuite()
	{
		System.out.println("Before Suite");
		
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");
		
	}
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Before Class");

	}
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		System.out.println("Before Method");
		System.out.println("Launch the browser");
		//String Browser=files.readindataproperti("browser");
		String Browser=System.getProperty("browser");

		 if(Browser.equalsIgnoreCase("chrome"))

		    {
		    	driver=new ChromeDriver();
		    	
		    }
		    else if(Browser.equalsIgnoreCase("Firefox"))

		    {
		    	driver=new FirefoxDriver();
		    	
		    }
		    else if(Browser.equalsIgnoreCase("edge"))
		    {
		    	driver=new EdgeDriver();

		    }
				
		    else
		    {
		    	driver=new ChromeDriver();

		    }
		   sdriver=driver;
		//WebDriver driver = null;
		System.out.println("Before Method");
		System.out.println("Login");
		String URL=files.readindataproperti("Url");
		//String UserName=System.getProperty("username");
		//String Password=System.getProperty("password");
		String UserName=files.readindataproperti("username");
		String Password=files.readindataproperti("password");
		driver.get(URL);
		Loginpage log=new Loginpage(driver);
		log.Login(UserName, Password);		
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After Method");
		driver.close();
	}
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After Class");
		
	}
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test");
		
	}
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("After Suite");
		
	}
	
	
	
}
