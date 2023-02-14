package com.Inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Inetbanking.base.Base;
import com.Inetbanking.pageobjects.Loginpage;
import com.Inetbanking.utilities.Excelutils;
@Listeners(com.Inetbanking.utilities.Extentreporting.class)
public class Logindatadriven extends Base{
	
	
	
	@Test(dataProvider="dp")

	public void loginddd(String user,String password) throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		lp.username(user);
		log.info("User name entered");
		lp.password(password);
		log.info("Password entered");
		lp.login();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Login success");
		}
	}
	
	@DataProvider(name="dp")
	public String[][] getdata() throws IOException
	{
		String path="C:\\Users\\radkr\\eclipse-workspacenew\\Inetbanking\\src\\test\\java\\com\\Inetbanking\\testdata\\datadrivenxl.xlsx";
		int rowcount=Excelutils.getRowCount(path, "Sheet1");
		int colcount=Excelutils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=Excelutils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
		
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
	catch(NoAlertPresentException e)
		{
		return false;
		}
	
	}
	
	

}
