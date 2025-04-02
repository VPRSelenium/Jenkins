package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {

	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement AddProduct;
	
	
	@FindBy(xpath="//input[@placeholder='Search by product Id']")
	private WebElement Search;
	
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement SelectDrop;
	
	
	
	public Products(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void AddProduct() throws InterruptedException
	{
		Thread.sleep(3000);
		AddProduct.click();	
	}
	
}
