package com.klindziuk.springthreadlocal.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.klindziuk.springthreadlocal.BrowserDriver;

@ContextConfiguration(locations = { "file:src/test/resourses/springcontext.xml" })
public class TestNGSeleniumDriverInjection extends AbstractTestNGSpringContextTests {
	
	@Test
    public void testMethod1() {
        invokeBrowser("http://www.ndtv.com");
    }
 
    @Test
    public void testMethod2() {
        invokeBrowser("https://www.facebook.com");
 
    }
    @Test
    public void testMethod3() {
        invokeBrowser("http://protesting.ru");
    }
 
    @Test
    public void testMethod4() {
        invokeBrowser("http://www.tottenhamhotspur.com/");
 
    }
    @Test
    public void testMethod5() {
        invokeBrowser("http://www.bbc.com/");
    }
    
   	@AfterSuite
	public void quitDriver() throws Exception {
		Runtime.getRuntime().exec("taskkill /f /IM chromedriver.exe");
	}
	
	private void invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + BrowserDriver.getDriver().hashCode());
        BrowserDriver.getDriver().get(url);
     }
}
