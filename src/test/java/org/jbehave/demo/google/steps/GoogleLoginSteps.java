package org.jbehave.demo.google.steps;

import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.demo.google.BaseSeleniumActions;
import org.jbehave.demo.google.pages.GoogleAfterLoginPage;
import org.jbehave.demo.google.pages.GoogleHomePage;
import org.jbehave.demo.google.pages.GoogleServiceLogin;
import org.junit.Assert;

/**
 * @author Vadym_Goncharenko
 *
 */
public class GoogleLoginSteps extends BaseSeleniumActions {

	public GoogleLoginSteps() throws Exception {
		super();
	}

	private GoogleHomePage homePage;
	private GoogleServiceLogin loginPage;
	private GoogleAfterLoginPage resultPage;
	private Map<String, String> message;

	@Given("home google page $url")
	public void givenGoogleBasePage(String url) {
		open(url);
		homePage = new GoogleHomePage(getSelenium());
	}
	
	@Given("gmail authentication form")
	public void givenGoogleAuthenticationForm() {
		loginPage = homePage.clickLoginButton();
	}
	
	@When("the user has entered valid username\\password")
	public void whenEnteredWrongAccount() {
		loginPage.enterUserName("validtestjbehave@gmail.com");
		loginPage.enterPassord("validtestpassword");
	}

	@When("the user has entered wrong username\\password")
	public void whenEnteredValidAccount() {
		loginPage.enterUserName("wrong@gmail.com");
		loginPage.enterPassord("wrong");
	}
	
	

	@When("log-in button has been pressed")
	public void whenPressedLoginButton() {
		loginPage.pressEnterButton();
	}
	
	@When("log button has been pressed")
	public void whenPressed() {
		resultPage = loginPage.pressButton();
		
	}

	@Then("the user should see corresponding error message: $examplesTable")
	public void thenExpectingErrorMessage(ExamplesTable examplesTable) {
		message = examplesTable.getRow(0);
		Assert.assertTrue(loginPage.isLoginErrorMessage(message.get("message")));
	}
	
	@Then("the user should see his name in right coner of the page: $examplesTable")
	public void thenExpectingEmailName(ExamplesTable examplesTable) {
		message = examplesTable.getRow(0);
		Assert.assertTrue(resultPage.isLoginNamePresent(message.get("message")));
	}
	
	
}
