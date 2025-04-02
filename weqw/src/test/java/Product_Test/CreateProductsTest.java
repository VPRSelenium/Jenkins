package Product_Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.Baseclass;
import ObjectRepositary.CreateProducts;
import ObjectRepositary.DashBoard;
import ObjectRepositary.Loginpage;
import ObjectRepositary.Products;
import UtilityProperites.FileUtilities;
import UtilityProperites.JavaUtilities;

public class CreateProductsTest extends Baseclass{

	
	@Test(priority=3,groups={"FunctionalTest"} )
	public  void CreateProduct() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileUtilities files=new FileUtilities();
		JavaUtilities ran=new JavaUtilities();
		int Rns = ran.random(1000);
		
	   String ProductName = files.Excelrr("Products", 1, 0)+Rns;
	   String Quantity =	files.Excelrr("Products", 1, 1);
	   String Price =	files.Excelrr("Products", 1, 1);

       
 	

       DashBoard prodcutclikc=new DashBoard(sdriver);
       Products Addpro=new Products(sdriver);
       Loginpage log=new Loginpage(sdriver);
       CreateProducts create=new CreateProducts(sdriver);
       sdriver.manage().window().maximize();
       sdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
       prodcutclikc.Product();
       Addpro.AddProduct();
       create.createProduct(ProductName, Quantity, Price);
       WebElement Verification = sdriver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(3000);
		String Status = Verification.getText();
		Thread.sleep(3000);
        System.out.println(Status);
		boolean Con = Status.contains("Successfully Added");
		System.out.println(Con);
		Assert.assertTrue(Con, "Product is not added");
	    Reporter.log("product is added");
	}

}
