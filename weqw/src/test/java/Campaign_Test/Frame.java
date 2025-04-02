package Campaign_Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Frame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.switchTo().frame(0);
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hi");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
	    Thread.sleep(3000);
	    WebElement Frame1 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(Frame1);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hi");
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[contains(text(),'Single Iframe')]")).click();
        
        //authenticationpopup
        //un:pass@url

	}

}
