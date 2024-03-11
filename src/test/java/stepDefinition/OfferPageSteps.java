package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageSteps {

	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public OfferPageSteps(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}



	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws Exception {
		switchToOffersPage();
		OffersPage offersPage=testContextSetup.pageObjectManager.OffersPage();;

		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName=offersPage.getProductName();
		System.out.println("OfferPageProduct " +offerPageProductName);

	}
	public void switchToOffersPage() {
		LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		testContextSetup.genericUtils.switchWindowToChild();
	}

	@Then("validate product name in offers page mateches with Landing Page")
	public void validate_product_name_in_offers_page_mateches_with_landing_page() {

		Assert.assertEquals(testContextSetup.productName, offerPageProductName);


	}

}
