package pageobject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import utility.ExtentReport;
import utility.Logs;

public class Footer {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public Footer(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	public void clickOnFooterLink(By element,String pageTitle) throws InterruptedException, IOException {
		exReport.enterInfoLog("Clicking on the "+pageTitle+" link in footer");
		logs.enterInfoLog("Clicking on the "+pageTitle+" link in footer");
		Thread.sleep(1000);
		webDriver.clickElement(driver, element);
		if(webDriver.getPageTitle(driver).toLowerCase().contains(pageTitle.toLowerCase())) {
			exReport.enterPassLogWithSnap(pageTitle+" page as opened");
			logs.enterInfoLog(pageTitle+" page as opened");
			Assert.assertTrue(true);
		}else {		
			exReport.enterFailLogWithSnap(pageTitle+" page as not opened");
			logs.enterInfoLog(pageTitle+" page as not opened");
			Assert.assertTrue(false);
		}
	}
}
