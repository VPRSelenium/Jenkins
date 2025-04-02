package ObjectRepositary;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityProperites.WebDriveruti;

public class CreateContacts {
	
	WebDriveruti driv=new WebDriveruti();
	
	@FindBy(name="contactName")
	private WebElement CName;
	
	@FindBy(name="title")
	private WebElement Title;
	
	@FindBy(name="mobile")
	private WebElement Mobilee;

	@FindBy(name="organizationName")
	private WebElement Org;

	@FindBy(xpath="//button[contains(@style,'white-space')]")
	private WebElement Camp;
	

	@FindBy(id="search-input")
	private WebElement searcch;

	@FindBy(id="search-criteria")
	private WebElement drop;
	
	@FindBy(xpath="//button[@class='select-btn']")
	private WebElement select;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement CreateContc;
	
	public CreateContacts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void createcon(WebDriver driver,String Cn,String Tit,String Mob,String ss,String Orgs) throws InterruptedException
	{
		CName.sendKeys(Cn);
		Title.sendKeys(Tit);
		Mobilee.sendKeys(Mob);
		Org.sendKeys(Orgs);
		Camp.click();	
		driv.WindowHandle1(driver,"selectCampaign");
		driv.select1(drop, 1);
    	searcch.sendKeys(ss);
    	select.click();
    	driv.WindowHandle1(driver, "create-contact");
    	Thread.sleep(3000);
    	CreateContc.click();
	}
	
	
      
	
	
}

