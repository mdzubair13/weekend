package org.weekend;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	 static WebDriver driver;
	public static void screenShot(String name) throws IOException {
		TakesScreenshot t= (TakesScreenshot)driver;
		//take screenshot
		File src = t.getScreenshotAs(OutputType.FILE);
		//new file location
		File des= new File("C:\\Users\\zubee\\ClassWorkSpace\\weekend\\Screenshot\\"+name+".png");
		//copy the file File
		FileUtils.copyFile(src, des);

	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\zubee\\ClassWorkSpace\\weekend\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		WebElement txtuser = driver.findElement(By.id("email"));
		txtuser.sendKeys("asfadf");
		screenShot("username");
		WebElement txtpass = driver.findElement(By.id("pass"));
		txtpass.sendKeys("12133");
		screenShot("userpasss");
		
		driver.findElement(By.name("login")).click();
		Thread.sleep(7000);
		screenShot("afterlogin");
		
	}
}
