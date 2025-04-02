package DDT_Properties;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

	public static void main(String[] args) {
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
	         driver.findElement(By.name("campaignName")).sendKeys("pradhiv5");
	         driver.findElement(By.name("targetSize")).clear();
	         driver.findElement(By.name("targetSize")).sendKeys("101");
	         driver.findElement(By.name("expectedCloseDate")).sendKeys("22-02-1999");
	         
	         Date dsa=new Date();
	         SimpleDateFormat ss=new SimpleDateFormat("dd-mm-yyy");
	          String form = ss.format(dsa);
	          System.out.println(form);
	          
	        Calendar cc = ss.getCalendar();
	     //  ff= cc.add(Calendar.DAY_OF_MONTH, 30);	       
	          System.out.println(form);

	         /*
	         driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
	         String verify=  driver.findElement(By.xpath("//div[@role='alert']")).getText();
		       
		       if(verify.contains("pradhiv5"))
		       {
		    	   System.out.println("added");
		       }
		       else
		       {
		    	   System.out.println("not added");
		       }
		       */
	}

}
