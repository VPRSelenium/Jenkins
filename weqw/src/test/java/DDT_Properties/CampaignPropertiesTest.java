package DDT_Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CampaignPropertiesTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//URl
		String File="C:\\Users\\pradhiv.v\\eclipse-workspace\\weqw\\src\\test\\resources\\CampaignDDT.properties";
		FileInputStream Files=new FileInputStream(File);
		Properties lo=new Properties();
        lo.load(Files);
        
      String Browser=lo.getProperty("browser");
      String URL=lo.getProperty("Url");
      String UserName = lo.getProperty("username");
      String PassWord =lo.getProperty("password");
      
      
      
      String Camp =lo.getProperty("campaign");
      String SET =lo.getProperty("set");

        WebDriver driver;
        
        
        if(Browser.equalsIgnoreCase("chrome"))
        {
        	driver =new ChromeDriver();
        }
        else if(Browser.equalsIgnoreCase("firefox"))
        {
        	driver =new FirefoxDriver();
        }
        else if(Browser.equalsIgnoreCase("edge"))
        {
        	driver =new EdgeDriver();
        }
        else
        {
        	driver =new ChromeDriver();
        }
        
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys(UserName);
        driver.findElement(By.id("inputPassword")).sendKeys(PassWord);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        driver.findElement(By.xpath("//a[text()='Campaigns']")).click();	   
        driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
        driver.findElement(By.name("campaignName")).sendKeys(Camp);
        driver.findElement(By.name("targetSize")).clear();
        driver.findElement(By.name("targetSize")).sendKeys("100");
        driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
        Thread.sleep(3000);
	       String verify=  driver.findElement(By.xpath("//div[@role='alert']")).getText();
	       
	       if(verify.contains(Camp))
	       {
	    	   System.out.println("added");
	       }
	       else
	       {
	    	   System.out.println("not added");
	       }
	       
	        
        
	}

}
