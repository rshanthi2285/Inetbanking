package com.Inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Inetbanking.base.Base;

public class Screenshot extends Base{
	
	public static String CaptureScreenShot1(String screenshotName) throws IOException
	{
		
		String dateName=new SimpleDateFormat("YYYYMMDD").format(new Date());
		TakesScreenshot ts=((TakesScreenshot)driver);
		File Source=ts.getScreenshotAs(OutputType.FILE);
		String dest=".\\test-output\\screenshot"+screenshotName+dateName;
		File destination=new File(dest);
		FileUtils.copyFile(Source, destination);
		return dest;
		
	}

}
