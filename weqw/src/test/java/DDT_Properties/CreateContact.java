package DDT_Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		String file="E:\\eclipse-workspace\\weqw\\src\\test\\resources\\Properties\\DataDDTProp.properties";
		FileInputStream newww=new FileInputStream(file);
		Properties re=new Properties();
	    String Browser=	re.getProperty("browser");
	    String URL=	re.getProperty("Url");
	    String UserName=re.getProperty("username");
	    String Password=re.getProperty("password");
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
		        driver.findElement(By.id("inputPassword")).sendKeys(Password);
		        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		        
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	         driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	         Thread.sleep(3000);
	         driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	         driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
	         driver.findElement(By.name("contactName")).sendKeys("orgaisss");
	         driver.findElement(By.name("mobile")).sendKeys("9840761888");
	         driver.findElement(By.name("title")).sendKeys("jai");
	         driver.findElement(By.name("organizationName")).sendKeys("tsk");
             driver.findElement(By.xpath("//button[contains(@style,'white-space')]")).click();
             
            Set<String> SS = driver.getWindowHandles();
             Iterator<String> iter = SS.iterator();
             boolean vv = iter.hasNext();
             
             while(vv)
             {
            	String main= iter.next(); 
            	String main2= iter.next(); 
            	driver.switchTo().window(main2);
                driver.findElement(By.xpath("//button[contains(@onclick,'Campaign1')]")).click();
            	driver.switchTo().window(main);
             }
             driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
             String verify=  driver.findElement(By.xpath("//div[@role='alert']")).getText();
                System.out.println(verify);
		       if(verify.contains("orgaisss"))
		       {
		    	   System.out.println("added");
		       }
		       else
		       {
		    	   System.out.println("not added");
		       }
		       WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
		        Actions action=new Actions(driver);
		        action.moveToElement(logoutBtn).click().perform();
		        //close the browser
		        driver.quit();
		       
		       

	         }

}
