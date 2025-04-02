package Campaign_Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepositary.Campaigns;
import ObjectRepositary.CreateCampaigns;
import ObjectRepositary.Loginpage;
import UtilityProperites.FileUtilities;
import UtilityProperites.JavaUtilities;
import UtilityProperites.WebDriveruti;

public class CreateCampaignWithClosedDate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		JavaUtilities javaa=new JavaUtilities();
		FileUtilities files=new FileUtilities();
		String Browser=files.readindataproperti("browser");
		String URL=files.readindataproperti("Url");
		String UserName=files.readindataproperti("username");
		String Password=files.readindataproperti("password");
		
		int Rnam = javaa.random(1000);
		
		String CampNamee = files.Excelrr("Products", 1, 0)+Rnam;
		String TSi = files.Excelrr("Products", 1, 1);


		WebDriver driver ;
		
		 if(Browser.equalsIgnoreCase("chrome"))

		    {
		    	driver=new ChromeDriver();
		    	
		    }
		    else if(Browser.equalsIgnoreCase("Firefox"))

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
		Loginpage log=new Loginpage(driver);
	    Campaigns camp =new Campaigns(driver);
	    CreateCampaigns creca=new CreateCampaigns(driver);
	    WebDriveruti web=new WebDriveruti();
	    driver.get(URL);
	    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	    web.Maximize(driver);
		log.Login(UserName, Password);
		camp.CreateCamp(); 
		String date = javaa.generateReqDate(30);
		creca.createCampaignWithCloseDate(CampNamee, TSi,date );
		
		
		
    
	}

}
