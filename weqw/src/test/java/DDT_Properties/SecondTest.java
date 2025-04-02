package DDT_Properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  WebDriver driver =new ChromeDriver();
	         
	         driver.get("http://49.249.28.218:8098/");
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	         driver.findElement(By.id("username")).sendKeys("rmgyantra");
	         driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	         driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	         driver.findElement(By.xpath("//a[text()='Campaigns']")).click();	   
	         driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	         driver.findElement(By.name("campaignName")).sendKeys("pradhiv3");
	         driver.findElement(By.name("targetSize")).clear();
	         driver.findElement(By.name("targetSize")).sendKeys("100");
	         driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
	       
	         Thread.sleep(3000);
	       String verify=  driver.findElement(By.xpath("//div[@role='alert']")).getText();
	       
	       if(verify.contains("pradhiv3"))
	       {
	    	   System.out.println("added");
	       }
	       else
	       {
	    	   System.out.println("not added");
	       }
	       
	        
	       

	}

}
