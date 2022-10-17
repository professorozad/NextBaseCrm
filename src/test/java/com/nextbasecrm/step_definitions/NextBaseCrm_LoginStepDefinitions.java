package com.nextbasecrm.step_definitions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.NextBaseCrmHomePage;
import com.nextbasecrm.pages.NextBaseCrmLoginPage;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NextBaseCrm_LoginStepDefinitions {

    NextBaseCrmLoginPage nextBaseCrmLoginPage = new NextBaseCrmLoginPage();

    NextBaseCrmHomePage nextBaseCrmHomePage = new NextBaseCrmHomePage();

    Faker faker = new Faker();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        nextBaseCrmLoginPage.loginLink.click();
    }
    @When("user enters {string},{string}")
    public void user_enters(String email, String password) {
        nextBaseCrmLoginPage.userNameInput.sendKeys(email);
        nextBaseCrmLoginPage.passwordInput.sendKeys(password);
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
       nextBaseCrmLoginPage.loginButton.click();
    }
    @Then("user should see username on the profile tab")
    public void user_should_see_username_on_the_profile_tab() {
        Assert.assertTrue(nextBaseCrmHomePage.idName.isDisplayed());
        System.out.println("username = " + nextBaseCrmHomePage.idName.getText());
    }











}
