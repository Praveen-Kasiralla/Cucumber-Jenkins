package stepDefination;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uistore.FooterUi;
import utility.BaseClass;
import utility.ConfigReader;

public class FooterLink extends BaseClass {
	@When("clicking on styling link in footer")
	public void clicking_on_styling_link_in_footer() throws InterruptedException, IOException {
		exReport.createNewTestReport("Clicking on styling link");
		footer.clickOnFooterLink(FooterUi.styling, "styling");
	}

	@Then("verify if {string} is present in articals")
	public void verify_if_is_present_in_articals(String artical)
			throws InterruptedException, IOException, InstantiationException, IllegalAccessException {
		exReport.createNewTestReport("Verifying the artical name");
		styling.styleArticalContains(artical);
	}

	@Given("Initialize the {string}  browser")
	public void initialize_the_browser(String browser) throws IOException {
		required();
		driverSetUp(browser);
	}

	@Then("navigate to {string}  website")
	public void navigate_to_website(String url) {
		exReport.createNewTestReport("Open Gillette");
		webDriver.openPage(driver, url);
		if (webDriver.getCurrentUrl(driver).equals(ConfigReader.getUrl())) {
			exReport.enterInfoLog("Gillette as opened");
			logs.enterInfoLog("Gillette as opened");
		} else {
			exReport.enterPassLog("Gillette didn't open");
		}
	}

	@Then("exit the  browser")
	public void exit_the_browser() throws IOException {
		driverExit();
	}
}
