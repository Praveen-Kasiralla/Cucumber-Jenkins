package pageobject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.HomePageUi;
import utility.BaseClass;
import utility.ExtentReport;
import utility.Logs;

public class HomePage extends BaseClass {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public HomePage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}

	public void searchItem(String product) throws InterruptedException, IOException {
		exReport.enterInfoLog("Searching for " + product);
		logs.enterInfoLog("Searching for " + product);
		webDriver.clickElement(driver, HomePageUi.searchIcon);
		if (!webDriver.getText(driver, HomePageUi.searchBox).equals(null))
			webDriver.clearText(driver, HomePageUi.searchBox);
		webDriver.sendText(driver, HomePageUi.searchBox, product, Keys.ENTER);
	}

	public void hoverAndClick(String pageTitle, By visibleOption, By dropdownOption)
			throws InterruptedException, IOException {
		exReport.enterInfoLog("Hovering on 'Products' and clicking on 'MOCH3'");
		logs.enterInfoLog("Hovering on 'Products' and clicking on 'MOCH3'");
		webDriver.hover(driver, visibleOption, dropdownOption);
		if (webDriver.getPageTitle(driver).toLowerCase().contains(pageTitle.toLowerCase())) {
			exReport.enterPassLogWithSnap("Clicking page as opened");
			logs.enterInfoLog("Clicking page as opened");
			Assert.assertTrue(true);

		} else {
			exReport.enterFailLogWithSnap("Wrong page as opened");
			logs.enterInfoLog("Wrong page as opened");
			Assert.assertTrue(false);

		}
	}

}
