package com.searchproduct.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Product {
	static WebDriver driver;
	static Actions action;
	@BeforeSuite
	public void startProject()
	{
		System.out.println("Automation project started");
	}
	
	@AfterSuite
	public void endProject()
	{
		System.out.println("Automation project Ended");
	}
	@Test
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		driver.get("https://www.bestbuy.ca/en-ca");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("ipad");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		List<WebElement> productList = driver.findElements(By.xpath("//*[@class='captionContainer_2uFG1']/p"));
		for(WebElement s:productList )
		{
			if(s.getText().equalsIgnoreCase("ipad"))
			{
				action = new Actions(driver);
				action.moveToElement(s).click().build().perform();
				break;
			}
			
			
		}
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		List<WebElement> mobileList = driver.findElements(By.xpath("//div[@class='productItemName_3IZ3c detailsBelow_3RbA6']/span"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,900)");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mobileList.get(2).click();
		
	
		
	}
	

}
