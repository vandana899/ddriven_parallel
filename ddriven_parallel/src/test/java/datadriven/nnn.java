package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nnn {
WebDriver driver;
public static String user="Admin";
public static String user12="Admin";
public String  org="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";



@Test
public void cs1() throws  IOException, InterruptedException {
	WebDriverManager.chromedriver().setup();
	//File myexcel=new File("C:/Users/hp/Desktop/training/positive_negative_inputs.xlsx");
	FileInputStream fis=new FileInputStream("C://Users//hp//Downloads//filereader");
			XSSFWorkbook wb = new XSSFWorkbook(fis);//total
	XSSFSheet ss=wb.getSheet("Sheet1");//particular
	int rowcount = ss.getLastRowNum();
	System.out.println(rowcount);
	for (int i = 0; i<=rowcount;i++) {
	
		String user =ss.getRow(i).getCell(0).getStringCellValue();
		System.out.println(user);
		String pass =ss.getRow(i).getCell(1).getStringCellValue();
		System.out.println(pass);
		driver = new ChromeDriver();
		driver.get(org);
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(user12);
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		String str= driver.getCurrentUrl();
				if(str.equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
				
		
		
}
	
}
}
