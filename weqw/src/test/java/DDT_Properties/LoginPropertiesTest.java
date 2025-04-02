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

import UtilityProperites.FileUtilities;

public class LoginPropertiesTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		//Properties vv=new Properties(ss);
		
		FileUtilities ni=new FileUtilities();
		String Browser=ni.readindataproperti("browser");
		String URL=ni.readindataproperti("Url");
		String Username=ni.readindataproperti("username");
		String Password =ni.readindataproperti("password");
		
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
        driver.findElement(By.id("username")).sendKeys(Username);
        driver.findElement(By.id("inputPassword")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	}

}
