package DDTJson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import UtilityProperites.FileUtilities;

public class CreateProduct {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		FileUtilities objj=new FileUtilities();
		
		 String Browser=objj.readingJson("browser");
		 String URL=objj.readingJson("Url");
		 String UserName=	objj.readingJson("username");
		 String Password=	objj.readingJson("password");

		            WebDriver driver;
		   		 if(Browser.equalsIgnoreCase("chrome"))
		   			{
		   				driver=new ChromeDriver();
		   			}
		   			else if(Browser.equalsIgnoreCase("firefox"))
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
		   		
		           driver.get(URL);
		           driver.manage().window().maximize();
		           driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		           driver.findElement(By.id("username")).sendKeys(UserName);
		           driver.findElement(By.id("inputPassword")).sendKeys(Password);
		           driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		            
	}
	
	//create jsonparser-(class-coming from simple json api) class object
	//create filereader object nad store the files
	//after creating object we have to convert java object to json object
	//after converting get method 

	
	//advantage of json file
	//-it is easy to use
    //-we can store all kind of data types
	//it is language independent /platform indeppendent
}
