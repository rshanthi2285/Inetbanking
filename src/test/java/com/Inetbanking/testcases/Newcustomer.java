package com.Inetbanking.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Inetbanking.base.Base;
import com.Inetbanking.pageobjects.Addcustomerpage;
import com.Inetbanking.pageobjects.Loginpage;


@Listeners(com.Inetbanking.utilities.Extentreporting.class)
public class Newcustomer extends Base {
	
	@Test
	public void test2() throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		lp.username(username);
		log.info("username entered");
		Thread.sleep(5000);
		lp.password(password);
		log.info(" password entered");
		lp.login();
		
		Addcustomerpage cust=new Addcustomerpage(driver);
		String emails=randomString()+"@gmail.com";
		
		cust.addnewcus();
		log.info(" Adding cust details");
		cust.cname("shanthi");
		cust.genders("female");
		cust.dateofbirth("198501", "02","12");
		cust.addres("Canada");
		cust.cityname("Whitby");
		cust.state("ontario");
		cust.pincode(123456);
		cust.mobnum("4567896789");
		cust.emailid(emails);
		cust.password("shanthi@123");
		cust.submit();
		
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info(" test passed");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("test failed");
		}
		
		
	}
	
	

}
