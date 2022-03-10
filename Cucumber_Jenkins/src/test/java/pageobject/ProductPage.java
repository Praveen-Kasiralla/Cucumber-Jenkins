package pageobject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.ProductPageUi;
import utility.ExtentReport;
import utility.Logs;

public class ProductPage {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public ProductPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(ProductPage.class);
	}
	public void checkSearchHeading(String product) throws IOException {
		exReport.enterInfoLog("Checking if the name of the search heading contains '"+product+"'");
		logs.enterInfoLog("Checking if the name of the search heading contains '"+product+"'");
		String heading = "Results For \""+product+"\"";
		if(webDriver.getText(driver, ProductPageUi.searchHeading).contains(heading)) {
			exReport.enterPassLogWithSnap("The name of the search heading contains '"+product+"'");
			logs.enterInfoLog("The name of the search heading contains '"+product+"'");
			Assert.assertTrue(true);

		}else {
			Assert.assertTrue(false);

		}
	}
}
