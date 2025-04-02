package DDT_Excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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

public class AddProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
  
		// to load all the value from properties for (common data login page)
		String LoginPropFile="C:\\Users\\pradhiv.v\\eclipse-workspace\\weqw\\src\\test\\resources\\Properties\\DataDDTProp.properties";
		FileInputStream prop=new FileInputStream(LoginPropFile);
		Properties file = new Properties();
		file.load(prop);
	    String Browser = file.getProperty("browser");
		String URL = file.getProperty("Url");
		String Password = file.getProperty("password");
	    String UserName = file.getProperty("username");
	    
	    //Load excel data
	    String Excel ="C:\\Users\\pradhiv.v\\eclipse-workspace\\weqw\\src\\test\\resources\\Excel\\Product.xlsx";
	    FileInputStream Excl =new FileInputStream(Excel);
	    Workbook Sheets = WorkbookFactory.create(Excl);
	    Random num=new Random();
	    int Integ = num.nextInt(100);
	    
    	String PName= Sheets.getSheetAt(0).getRow(1).getCell(0).getStringCellValue()+Integ;
	    String Quan=   Sheets.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
	    String Pri= Sheets.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
	    
	    //create webdriver and script for add product

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
	      driver.findElement(By.id("inputPassword")).sendKeys(Password);
	      driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[text()='Products']")).click();
		  driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		  
		
		 driver.findElement(By.name("productName")).sendKeys(PName);
		 driver.findElement(By.name("quantity")).sendKeys(Quan);
	     driver.findElement(By.name("price")).sendKeys(Pri);
	     
         WebElement cate=  driver.findElement(By.name("productCategory"));     
         WebElement vend=  driver.findElement(By.name("vendorId"));     

	     Select drop =new Select(cate);
	     Select drops =new Select(vend);
	     drop.selectByIndex(1);
	     drops.selectByIndex(2);
         driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(3000);
         String ConfirmationMsg = driver.findElement(By.xpath("//div[text()='Product "+PName+" Successfully Added']")).getText();
	    String sss= driver.findElement(By.xpath("//div[@role='alert']")).getText();
	 //    System.out.println(ConfirmationMsg);

	     if(sss.contains("Successfully Added"))
	     {
		     System.out.println(sss);

	     }

	     else
	     {
		     System.out.println("Not added");

	     }
	}

}
