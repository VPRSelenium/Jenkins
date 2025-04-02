package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	
	// declaration
	
	@FindBy (name="username")
	private WebElement UserName;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement SignIn;
	
	
	@FindBy(xpath="//a[contains(text(),'Forgot password?')]")
	private WebElement Forgot;
	
	
	@FindBy(xpath="//a[contains(text(),'Create Account')]")
	private WebElement Account;
 
	//initalization
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	
	
	public void Login(String UName,String pass)
	{
		UserName.sendKeys(UName);
		Password.sendKeys(pass);
		SignIn.click();

	}
	
	
}


