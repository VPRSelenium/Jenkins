package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import UtilityProperites.FileUtilities;
import UtilityProperites.JavaUtilities;
public class ContactAndCampaign {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String exfile="E:\\eclipse-workspace\\weqw\\src\\test\\resources\\Excel\\Product.xlsx";
		 JavaUtilities uti=new JavaUtilities();
	        int ranumb = uti.random(1000);
	        
	       FileInputStream cont=new FileInputStream(exfile);
	       
		Workbook Work = WorkbookFactory.create(cont);
		String COntacName = Work.getSheetAt(0).getRow(1).getCell(3).getStringCellValue()+ranumb;
		String Mobile = Work.getSheetAt(0).getRow(1).getCell(4).getStringCellValue();
		String Title = Work.getSheetAt(0).getRow(1).getCell(5).getStringCellValue();
		String OrgName = Work.getSheetAt(0).getRow(1).getCell(6).getStringCellValue();

		FileUtilities log=new FileUtilities();
        String Browser=log.readindataproperti("browser");
        String URL=log.readindataproperti("Url");
        String UserName = log.readindataproperti("username");
        String PassWord =log.readindataproperti("password");
        
        
        
        FileUtilities read=new FileUtilities();
        String ccc = read.Excelrr("Products", 1, 0)+ranumb;
        String fff=  read.Excelrr("Products", 1, 1);
        
        WebDriver driver ;
          
          if(Browser.equalsIgnoreCase("chrome"))
          {
        	  driver =new ChromeDriver();
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
          driver.findElement(By.id("username")).sendKeys(UserName);
	      driver.findElement(By.id("inputPassword")).sendKeys(PassWord);
	      driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	      driver.findElement(By.xpath("//a[text()='Campaigns']")).click();	   
	      driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	       System.out.println(ccc);
           driver.findElement(By.name("campaignName")).sendKeys(ccc);
	       driver.findElement(By.name("targetSize")).clear();
	       driver.findElement(By.name("targetSize")).sendKeys(fff);
	       
	       Date co=new Date();
	       SimpleDateFormat  hh=new SimpleDateFormat ("dd-MM-yyyy");
	      String vb = hh.format(co);
	       System.out.println(vb);
	       
	       
	       driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
	       Thread.sleep(3000);
	       
	       
	       String verify=  driver.findElement(By.xpath("//div[@role='alert']")).getText();
	       
	       if(verify.contains(verify))
	       {
	    	   System.out.println("added");
	       }
	       else
	       {
	    	   System.out.println("not added");
	       }
	       
	       Thread.sleep(3000);
	       
	       
	         driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	         driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
	         driver.findElement(By.name("contactName")).sendKeys(COntacName);
	         driver.findElement(By.name("mobile")).sendKeys(Mobile);
	         driver.findElement(By.name("title")).sendKeys(Title);
	         driver.findElement(By.name("organizationName")).sendKeys(OrgName);
           driver.findElement(By.xpath("//button[contains(@style,'white-space')]")).click();
           
          Set<String> SS = driver.getWindowHandles();
           Iterator<String> iter = SS.iterator();
           boolean vv = iter.hasNext();
           
           while(vv)
           {
          	String main= iter.next(); 
          	String main2= iter.next(); 
          	driver.switchTo().window(main2);
            WebElement sfff = driver.findElement(By.id("search-criteria"));
        	Select shh =new Select(sfff);
        	shh.selectByIndex(1);
            driver.findElement(By.id("search-input")).sendKeys(ccc);
             driver.findElement(By.xpath("//button[@class='select-btn']")).click();
           	driver.switchTo().window(main);
            driver.findElement(By.xpath("//button[text()='Create Contact']")).click();

           }

	       
	       
	}

}
