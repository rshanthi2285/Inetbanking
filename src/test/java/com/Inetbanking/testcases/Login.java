package com.Inetbanking.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Inetbanking.base.Base;
import com.Inetbanking.pageobjects.Loginpage;

@Listeners(com.Inetbanking.utilities.Extentreporting.class)

public class Login extends Base {
	
	@Test
	public void test1() throws InterruptedException
			{
		Loginpage lp=new Loginpage(driver);
		lp.username(username);
		log.info("username entered");
		Thread.sleep(5000);
		lp.password(password);
		log.info(" password entered");
		lp.login();
		
		Thread.sleep(10000);
		
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
			}

}
