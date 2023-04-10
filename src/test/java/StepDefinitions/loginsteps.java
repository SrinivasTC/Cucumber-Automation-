package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Enters into loginpage");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		System.out.println("User entered username and password");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("User clicked on login button");
	}

	@Then("user navigated to the homepage")
	public void user_navigated_to_the_homepage() {
		System.out.println("User entered into the homepage");
	}


}
