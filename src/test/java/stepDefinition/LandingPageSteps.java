package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageSteps {

	public WebDriver driver;
	public String productName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	public LandingPageSteps(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
		testContextSetup.driver= new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("USer searched with shortname {string} and extracted actual name of product")
	public void u_ser_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);

		testContextSetup.productName=landingPage.getProductName().split("-")[0].trim();
		System.out.println("LandingPageProduct " + testContextSetup.productName);

	}

}
