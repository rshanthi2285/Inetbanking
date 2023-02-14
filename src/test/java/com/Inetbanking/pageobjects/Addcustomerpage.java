package com.Inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcustomerpage {
	
	public WebDriver driver;
	
	@FindBy(name="name")
	WebElement customername;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="pinno")
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	WebElement telephone;
	
	@FindBy(name="emailid")
	WebElement emailid;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement dateofbir;
	
	@FindBy(partialLinkText="New Customer")
	WebElement newcust;
	
	@FindBy(name="telephoneno")
	WebElement phno;
	
	
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(name="sub")
	WebElement sub;
	
	
	
	public Addcustomerpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	
	}
	
	public void submit()
	{
	sub.click();	
	}
	public void addnewcus()
	{
		newcust.click();
	}
	public void cname(String name)
	{
		customername.sendKeys(name);
	}
	
	public void addres(String add)
	{
		address.sendKeys(add);
		
	}
	
	public void cityname(String citys)
	{
		city.sendKeys(citys);
	}
	public void state(String states)
	{
		state.sendKeys(states);
	}
	public void pincode(int pin)
	{
		pincode.sendKeys(String.valueOf(pin));
	}
	
	public void mobnum(String ph)
	{
		phno.sendKeys(ph);
	}
	
	public void emailid(String email)
	{
		emailid.sendKeys(email);
	}
	
	public void password(String passwrd)
	{
		password.sendKeys(passwrd);
	}
	public void dateofbirth(String yy,String mm,String dd)
	{		
		
		dateofbir.sendKeys(yy);
		dateofbir.sendKeys(mm);
		dateofbir.sendKeys(dd);
	}
	
	public void genders(String gen)
	{
		gender.click();
	}




}
