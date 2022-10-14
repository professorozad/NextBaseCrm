package com.nextbasecrm.step_definitions;

import com.nextbasecrm.pages.NextBaseCrmLoginPage;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NextBaseCrm_StepDefinitions {


    NextBaseCrmLoginPage nextBaseCrmLoginPage = new NextBaseCrmLoginPage();


    @When("user enters helpdesk username")
    public void user_enters_helpdesk_username() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        nextBaseCrmLoginPage.loginLink.click();
        nextBaseCrmLoginPage.userNameInput.sendKeys("helpdesk1@cybertekschool.com");

    }
    @When("user enters helpdesk password")
    public void user_enters_helpdesk_password() {

        nextBaseCrmLoginPage.passwordInput.sendKeys("UserUser");
        nextBaseCrmLoginPage.loginButton.click();

    }
    @Then("user should navigate to home page")
    public void user_should_navigate_to_home_page() {

        Assert.assertTrue(nextBaseCrmLoginPage.idName.isDisplayed());
        System.out.println("nextBaseCrmLoginPage.idName = " + nextBaseCrmLoginPage.idName.getText());

    }







}
