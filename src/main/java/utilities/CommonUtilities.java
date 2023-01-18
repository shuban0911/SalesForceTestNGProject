package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtilities {
	
	public String getproperty(String key) throws IOException {
		
		//filepath
		String spath = System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties";
		//fileInputStream
		FileInputStream fileput = new FileInputStream(spath);
		Properties prop = new Properties();
		prop.load(fileput);
		String value = prop.getProperty(key);
		return value;
	}

	public void takeScreenshot(WebDriver driver) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String dest = ".//screenshots//saleshome"+screenshotTime()+".png";
		try {
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private String screenshotTime() {
		
		Date date = new Date();
		String newDate = date.toString().replace(" ","-").replace(":","-");
		return newDate;
	}
	
	public String getformattedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String date = sdf.format(new Date());
		return date;
	}
}
