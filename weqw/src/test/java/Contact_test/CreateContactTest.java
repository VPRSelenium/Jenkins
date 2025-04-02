package Contact_test;

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
import Campaign_Test.CreateCampaignWithClosedDate;
import ObjectRepositary.Campaigns;
import ObjectRepositary.CreateCampaigns;
import ObjectRepositary.CreateContacts;
import ObjectRepositary.DashBoard;
import ObjectRepositary.Loginpage;
import UtilityProperites.FileUtilities;
import UtilityProperites.JavaUtilities;
import UtilityProperites.WebDriveruti;

public class CreateContactTest extends Baseclass {

	//@Test(groups= {"SmokeTest"})
	@Test(priority=4,groups={"RegressionTest"})
	public  void CreateConatctTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		JavaUtilities javaa=new JavaUtilities();
		FileUtilities files=new FileUtilities();
		
		int Rnam = javaa.random(1000);
		
		String CampNamee = files.Excelrr("Products", 1, 0)+Rnam;
		String TSi = files.Excelrr("Products", 1, 1);

		
		
		CreateCampaignWithClosedDate cc=new CreateCampaignWithClosedDate();
		
		String Prodcutname = files.Excelrr("Products", 1, 0)+Rnam;
		String Org = files.Excelrr("Products", 1, 3);
		String Mob = files.Excelrr("Products", 1, 4);
		String Tit = files.Excelrr("Products", 1, 5);
		

		DashBoard dash=new DashBoard(sdriver);
		
	    Campaigns camp =new Campaigns(sdriver);
	    CreateCampaigns creca=new CreateCampaigns(sdriver);
	    WebDriveruti web=new WebDriveruti();
	    sdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	    sdriver.manage().window().maximize();
		camp.CreateCamp(); 
		String date = javaa.generateReqDate(30);
		creca.createCampaignWithCloseDate(CampNamee, TSi,date );
		Thread.sleep(3000);
		dash.cont();
		sdriver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		CreateContacts con=new CreateContacts(sdriver);
		con.createcon(sdriver, Prodcutname, Tit, Mob,CampNamee,Org);
		Thread.sleep(3000);
		WebElement Verification = sdriver.findElement(By.xpath("//div[@role='alert']"));
		String Status = Verification.getText();
		Thread.sleep(3000);
        System.out.println(Status);
		boolean Cons = Status.contains("Successfully Added");
		System.out.println(Cons);
		Assert.assertTrue(Cons, "Status is not added");
	    Reporter.log("Contact is added");
		
	}
    //Testng
	//Helper methods
	//priority-completed
	//invocation count -completed
	//thread poolsize- completed but working when we give inc-0 and poolsze=3
	//depends on methods-completed
	//parameter-
	//data provider-
	//enabled-completed
	
	//annotations-
	
	//reports generations-completed
	//parallel testing-completed
	//crossbrowser testiing-
	//group testing-
	//batch file execution-completed
	
	//Listeners
	
	//github
	//jenkins
	//maven
	
}
