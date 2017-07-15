package com.klindziuk.springthreadlocal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ThreadLocalWebDriver {
	static String browserName;
		
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		public WebDriver initialValue() {
			WebDriver driver = null;
	        if (browserName.toLowerCase().contains("firefox")) {
	            driver = new FirefoxDriver();
	            //TODO
	            return null;
	        }
	        if (browserName.toLowerCase().contains("ie")) {
	            driver = new InternetExplorerDriver();
	            //TODO
	            return null;
	        }
	        if (browserName.toLowerCase().contains("chrome")) {
	        	System.setProperty("webdriver.chrome.driver","C:/Users/Pavel_Klindziuk/Program_Files/ChromeDriver/chromedriver.exe");
	            driver = new ChromeDriver();
	            return driver;
	        }
	        return driver;
			}
	};
	
	public ThreadLocalWebDriver(String browserName){
		ThreadLocalWebDriver.browserName = browserName;
	}
	
	public WebDriver getDriver() {
		return threadDriver.get();
	}
}
