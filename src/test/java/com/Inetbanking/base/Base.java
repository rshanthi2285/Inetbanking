package com.Inetbanking.base;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Inetbanking.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	Readconfig config=new Readconfig();

	public static WebDriver driver;
	public String url=config.appurl();
	public String username=config.getUsername();
	public String password=config.getPassword();
	public static Logger log; 
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
		driver=WebDriverManager.chromedriver().create();
		}
		else if(br.equals("firefox"))
		{
		driver=WebDriverManager.firefoxdriver().create();
		}
		else if(br.equals("edge"))
		{
		driver=WebDriverManager.edgedriver().create();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	    log=Logger.getLogger("Inetbanking");
		PropertyConfigurator.configure("log4j.properties");
		driver.get(url);
		log.info("URL launched");
		
	}
	public String randomString()
	{
		String ran=RandomStringUtils.randomAlphabetic(7);
		return ran;
	}
	
	public String randomNumber()
	{
		String ran=RandomStringUtils.randomNumeric(5);
		return ran;
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
