package pageobject;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusable.WebDriverHelper;
import uistore.Mach3PageUi;
import utility.ExtentReport;
import utility.Logs;

public class Mach3Page {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public Mach3Page(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	public void ourProductsContains(String product) throws IOException {
		exReport.enterInfoLog("Checking if our porducts list contains "+product);
		logs.enterInfoLog("Checking if our porducts list contains "+product);
		List<WebElement> arr = webDriver.getMultipleText(driver, Mach3PageUi.ourProducts);
		boolean contains = false;
		for(WebElement element : arr) {
			if(element.getText().contains(product)) {
				exReport.enterPassLogWithSnap(product+" is in the 'our products' list");
				logs.enterInfoLog(product+" is in the 'our products' list");
				contains = true;
				Assert.assertTrue(true);
				break;
			}
		}
		if(!contains) {
			exReport.enterFailLogWithSnap(product+" is not in the 'our products' list");
			logs.enterInfoLog(product+" is not in the 'our products' list");
			Assert.assertTrue(false);
		}
	}
}
