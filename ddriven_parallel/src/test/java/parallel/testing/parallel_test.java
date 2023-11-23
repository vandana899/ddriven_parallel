package parallel.testing;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parallel_test {
	public String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	
@Parameters("{mybrowser}")
	@BeforeTest()
	public void befortest(@Optional("chrome") String mybrowser)
	{
		
		
		if(mybrowser.equalsIgnoreCase("Edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		
			
	}
		else if(mybrowser.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
			
		}
	
	}
	@Test
	public void test() throws InterruptedException
	{
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(7000);
		
		
	}
	
}

