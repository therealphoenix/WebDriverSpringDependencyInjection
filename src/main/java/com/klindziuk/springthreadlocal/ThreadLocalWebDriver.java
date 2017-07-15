package com.klindziuk.springthreadlocal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadLocalWebDriver {
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		public WebDriver initialValue() {
			System.setProperty("webdriver.chrome.driver","C:/Users/Pavel_Klindziuk/Program_Files/ChromeDriver/chromedriver.exe");
			return new ChromeDriver();
		}
	};

	public WebDriver getDriver() {
		return threadDriver.get();
	}
}
