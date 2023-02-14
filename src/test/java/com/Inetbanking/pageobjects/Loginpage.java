package com.Inetbanking.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
	public WebDriver driver;
	By Uid=By.name("uid");
	By pwd=By.name("password");
	By login=By.name("btnLogin");
	//By logout=By.xpath("/html/body/div[3]/div/ul/li[15]/a");
	By logout=By.partialLinkText("Log out");
	
	
    
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	
	}
	
	public void username(String uname)
	{
		driver.findElement(Uid).sendKeys(uname);
	}
	
	public void password(String pword)
	{
		driver.findElement(pwd).sendKeys(pword);
	}
	
	public void login()
	{
		driver.findElement(login).click();
	}
	public void logout()
	{
		driver.findElement(logout).click();
	}
	
	

}
