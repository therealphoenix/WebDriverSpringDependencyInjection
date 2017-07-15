package com.klindziuk.springthreadlocal;

import org.openqa.selenium.WebDriver;

public final class BrowserDriver {
	private static WebDriver driver;

	private BrowserDriver() {}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setWebDriver(WebDriver webDriver) {
		driver = webDriver;
	}
}
