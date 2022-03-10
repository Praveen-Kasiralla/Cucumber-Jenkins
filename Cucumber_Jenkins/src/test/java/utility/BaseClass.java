package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageobject.Footer;
import pageobject.HomePage;
import pageobject.Mach3Page;
import pageobject.ProductPage;
import pageobject.StylingPage;
import reusable.WebDriverHelper;

public class BaseClass {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExcelData excel;
	public String browser;
	public ExtentReport exReport;
	public Logs logs;
	public HomePage home;
	public ProductPage productp;
	public Footer footer;
	public Mach3Page moch3;
	public StylingPage styling;

	public void required() throws IOException {
		webDriver = new WebDriverHelper();
		excel = new ExcelData();
		logs = new Logs();

	}

	public void driverSetUp(String browse) throws IOException {
		browser = browse;
		if (ConfigReader.getBrowser(browser).contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (ConfigReader.getBrowser(browser).equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webDriver.implicitWait(driver, 10);
		exReport = new ExtentReport(driver);
		logs.createLogger(BaseClass.class);
		home = new HomePage(driver, webDriver, exReport);
		productp = new ProductPage(driver, webDriver, exReport);
		footer = new Footer(driver, webDriver, exReport);
		moch3 = new Mach3Page(driver, webDriver, exReport);
		styling = new StylingPage(driver, webDriver, exReport);

	}

	public void driverExit() throws IOException {
		exReport.flush();
		driver.quit();
	}
}
