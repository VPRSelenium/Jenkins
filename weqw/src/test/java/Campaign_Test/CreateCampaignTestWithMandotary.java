package Campaign_Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.Baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ObjectRepositary.Campaigns;
import ObjectRepositary.CreateCampaigns;
import ObjectRepositary.Loginpage;
import UtilityProperites.FileUtilities;
import UtilityProperites.JavaUtilities;
import UtilityProperites.WebDriveruti;

public class CreateCampaignTestWithMandotary extends Baseclass {

	//@Parameters("browser")
	//@Test(groups= {"SmokeTest"})
	
	@Test(priority=0,groups={"SmokeTest"})
	public void CreatecampTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		JavaUtilities javaa=new JavaUtilities();
		FileUtilities files=new FileUtilities();
		//String Browser =browser;
		
		int Rnam = javaa.random(1000);
		String CampNamee = files.Excelrr("Products", 1, 0)+Rnam;
		String TSi = files.Excelrr("Products", 1, 1);
		
        Campaigns camp =new Campaigns(sdriver);
		CreateCampaigns creca=new CreateCampaigns(sdriver);
	    WebDriveruti web=new WebDriveruti();
	    sdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	    web.Maximize(sdriver);
		camp.CreateCamp();
		creca.createCampaignWithmandatoryFields(CampNamee, TSi);
		WebElement Verification = sdriver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(3000);
		String Status = Verification.getText();
		Thread.sleep(3000);
        System.out.println(Status);
		boolean Con = Status.contains("Successfully Added");
		System.out.println(Con);
		Assert.assertTrue(Con, "Status is not added");
	    Reporter.log("campaign is added");

	}
//	@Parameters("browser")

	//@Test(groups= {"RegressionTest"})
	@Test(priority=1,groups={"SmokeTest"},dependsOnMethods={"CreatecampTest"})
	public void CampWithClosedDateTest() throws IOException, InterruptedException
	{
		JavaUtilities javaa=new JavaUtilities();
		//String Browser =browser;

		FileUtilities files=new FileUtilities();
		
		
		int Rnam = javaa.random(1000);
		
		String CampNamee = files.Excelrr("Products", 1, 0)+Rnam;
		String TSi = files.Excelrr("Products", 1, 1);
		
	    Campaigns camp =new Campaigns(sdriver);
	    CreateCampaigns creca=new CreateCampaigns(sdriver);
	    WebDriveruti web=new WebDriveruti();
	    sdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	    web.Maximize(sdriver);
		camp.CreateCamp(); 
		String date = javaa.generateReqDate(30);
		creca.createCampaignWithCloseDate(CampNamee, TSi,date );
		WebElement Verification = sdriver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(3000);
		String Status = Verification.getText();
		Thread.sleep(3000);
        System.out.println(Status);
		boolean Cons = Status.contains("Successfully Added");
		System.out.println(Cons);
		Assert.assertTrue(Cons, "Status is not added");
	    Reporter.log("campaign is added");
	   	
		
		 
	}

}
