package com.klindziuk.springthreadlocal.listener;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.klindziuk.springthreadlocal.BrowserDriver;
import com.klindziuk.springthreadlocal.ThreadLocalWebDriver;

@ContextConfiguration(locations = { "file:src/test/resourses/springcontext.xml" })
public class WebDriverListener extends AbstractTestNGSpringContextTests implements IInvokedMethodListener {
	@Autowired
	private ThreadLocalWebDriver threadLocalWebDriver;
	
	//https://jira.spring.io/browse/SPR-4072 -
	//Spring beans not available within @BeforeTest(BeforeInvocation) methods
	protected void springTestContextPrepareTestInstance() throws Exception {
	    super.springTestContextPrepareTestInstance();
	}
	 
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    	try {
			springTestContextPrepareTestInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
        if (method.isTestMethod()) {
        	WebDriver driver = threadLocalWebDriver.getDriver();
        	 BrowserDriver.setWebDriver(driver);
          }
    }
 
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
        	WebDriver driver = threadLocalWebDriver.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
