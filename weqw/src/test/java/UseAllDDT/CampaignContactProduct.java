package UseAllDDT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import UtilityProperites.FileUtilities;
import UtilityProperites.JavaUtilities;

public class CampaignContactProduct {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
      
		
		FileUtilities file=new FileUtilities();
		String Browser=file.readingJson("browser");
		String URL=file.readingJson("Url");
		String UserName=file.readingJson("username");
		String Password=file.readingJson("password");
		
		
    WebDriver driver;
    
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
    
    driver.get(URL);
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    driver.findElement(By.id("username")).sendKeys(UserName);
    driver.findElement(By.id("inputPassword")).sendKeys(Password);
    driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    driver.manage().window().maximize();
    String CurrentUrl = driver.getCurrentUrl();
    String ActualURl = "http://49.249.28.218:8098/";
		  
		  
  if(CurrentUrl.equals(ActualURl))
  {
    System.out.println("Entered into Dashboard Screen");
    
  }
  else
  {
	    System.out.println("Not Entered into Dashboard Screen");

  }
     JavaUtilities java=new JavaUtilities();
     int Rndoms = java.random(1000);
     String CurrentDate = java.dassdte();
     String EndDate = java.generateReqDate(30);
     String campaignName= file.Excelrr("Products", 1, 0)+Rndoms;
     String TargeSize= file.Excelrr("Products", 1, 1);

     driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
     driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
     driver.findElement(By.name("campaignName")).sendKeys(campaignName);
     driver.findElement(By.name("targetSize")).clear();
     driver.findElement(By.name("targetSize")).sendKeys(TargeSize);
     driver.findElement(By.name("expectedCloseDate")).sendKeys(EndDate);
     driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
     Thread.sleep(3000);
     WebElement verify = driver.findElement(By.xpath("//div[@role='alert']"));
      String VerificationText = verify.getText();
      System.out.println(VerificationText);
      
      if(VerificationText.contains("Successfully Added"))
      {
    	  System.out.println("Added successfully");
      }
      else 
      {
    	  System.out.println("Not added");

      }
      
      
  
	}}
