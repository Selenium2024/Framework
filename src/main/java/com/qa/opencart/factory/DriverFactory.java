package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.exception.FrameworkException;

public class DriverFactory {

	WebDriver driver;
	Properties prop;

	public WebDriver initDriver(Properties prop) {
		String browserName=prop.getProperty("browser");
		
		System.out.println("Browser name is : " + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "fireFox":
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Browser is invalid : ");
			throw new FrameworkException("No browser found");

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));

		return driver;

	}
	
	public Properties initprop() {
		 prop=new Properties();
		 
		 try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
			 prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return prop;
		 
	}

}
