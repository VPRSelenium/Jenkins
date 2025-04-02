package UtilityProperites;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriveruti {

	
	
	// windowHandles
	
	public void Window(WebDriver driver)
	{
		Set<String> Windowss = driver.getWindowHandles();
		Iterator<String> iterator = Windowss.iterator();
      while(iterator.hasNext())
      {
    	 String first= iterator.next();
    	 String Second= iterator.next();
    	 
      }
	}
	
	//select 
	public void select1 (WebElement value,int index)
	{
		Select dop =new Select(value);
		dop.selectByIndex(index);
	}
	
	public void select2(WebElement values,String values1)
	{
		Select dop =new Select(values);
		dop.selectByValue(values1);
		
	}
	public void select3(String visibleText,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	//frame
	public void switchto(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchto(WebDriver driver,String value)
	{
		driver.switchTo().frame(value);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void Maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	

  		  public void WindowHandle1(WebDriver driver,String partialUrl)
  		{
  			 Set<String> SS = driver.getWindowHandles();
  			 
  			 for(String NewWindow:SS)
  			 {
  				 driver.switchTo().window(NewWindow);
  				 String ActualUrl = driver.getCurrentUrl();
  				 if(ActualUrl.contains(partialUrl))
  						 {
  					         break;
  						 }
  				 
  			 }
  				 
  			 }
  		   
 	

	}

