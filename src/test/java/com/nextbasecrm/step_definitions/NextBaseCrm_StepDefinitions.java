package com.nextbasecrm.step_definitions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.NextBaseCrmHomePage;
import com.nextbasecrm.pages.NextBaseCrmLoginPage;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NextBaseCrm_StepDefinitions {


    NextBaseCrmLoginPage nextBaseCrmLoginPage = new NextBaseCrmLoginPage();
    NextBaseCrmHomePage nextBaseCrmHomePage = new NextBaseCrmHomePage();

    Faker faker = new Faker();


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


    @When("user are on the homepage")
    public void user_are_on_the_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        nextBaseCrmLoginPage.loginLink.click();
        nextBaseCrmLoginPage.userNameInput.sendKeys("helpdesk1@cybertekschool.com");
        nextBaseCrmLoginPage.passwordInput.sendKeys("UserUser");
        nextBaseCrmLoginPage.loginButton.click();


    }


    @Then("user writes the message and send")
    public void userWritesTheMessageAndSend() {
        // Click " Send message " box

        nextBaseCrmHomePage.sendMessageInputBox.click();

        // switch the iframe which is included this input box

        Driver.getDriver().switchTo().frame(nextBaseCrmHomePage.iframe);

        // write a comment with using faker

        nextBaseCrmHomePage.writeMessageBox.sendKeys(faker.chuckNorris().fact());


        // switch to parent frame for able to use send button

        Driver.getDriver().switchTo().parentFrame();

        nextBaseCrmHomePage.sendMessageButton.click();


    }

    @Then("user comment to first sent message")
    public void userCommentToFirstSentMessage() {

        // Go to first messsage in the activity stream and click " Add comment " box

        nextBaseCrmHomePage.getCommentBox.click();

        // switch the iframe which is include this input box

        Driver.getDriver().switchTo().frame(nextBaseCrmHomePage.iframe);

        // write a comment with using faker

        nextBaseCrmHomePage.writeCommentBox.sendKeys(faker.chuckNorris().fact());

        // switch to parent frame for able to use send button

        Driver.getDriver().switchTo().parentFrame();

        // click the send button
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.elementToBeClickable(nextBaseCrmHomePage.sendCommentButton));

        nextBaseCrmHomePage.sendCommentButton.click();

    }
}
