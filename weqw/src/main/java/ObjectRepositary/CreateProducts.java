package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityProperites.WebDriveruti;


public class CreateProducts {
	
	
	
	@FindAll({
    @FindBy(name="productName"),
	@FindBy(xpath="//input[@type='text']")
	})
	private WebElement ProdName;
	
	
	@FindBys({
		@FindBy(name = "quantity"),
		@FindBy(xpath = "//input[@type='number']")
	})
	private WebElement Quantity;
	
	@FindBy(name="price")
	private WebElement Price;
	

	@FindBy(name="vendorId")
	private WebElement Vendor;
	
	@FindBy(name="productCategory")
	private WebElement productCat;
	
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement Add;
	
	
	public CreateProducts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	WebDriveruti dso=new WebDriveruti();

	
	public void createProduct(String product,String Quan,String Pricec) throws InterruptedException
	{
		
		ProdName.sendKeys(product);
		Quantity.clear();
		Quantity.sendKeys(Quan);
		Price.clear();
		Price.sendKeys(Pricec);
		dso.select1(productCat, 2);
		dso.select1(Vendor, 2);
		Thread.sleep(3000);
		Add.click();
	}

}
