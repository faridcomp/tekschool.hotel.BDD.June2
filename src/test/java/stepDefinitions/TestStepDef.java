package stepDefinitions;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HotelHomePageObject;

public class TestStepDef extends Base {
	
	HotelHomePageObject hotelHomePage = new HotelHomePageObject (); 
	
	
	@Given("user is on hotel website")
	public void user_is_on_hotel_website() {
	  String actualTitle = driver.getTitle(); 
	  String expectedTitle = properties.getProperty("title"); 
	  Assert.assertEquals(expectedTitle, actualTitle); 
	  logger.info(actualTitle + " is equal to " + expectedTitle); 
	  
	}
	@When("user click on signin button")
	public void user_click_on_signin_button() {
		hotelHomePage.clickSignIn();
		logger.info("user clicked on Signin");
	  
	}
	@Then("user should see signin page")
	public void user_should_see_signin_page() {
		Assert.assertTrue(hotelHomePage.isAuthenticationDisplayed());
		Assert.assertTrue(hotelHomePage.isEmailPresent());

	}

}
