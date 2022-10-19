package com.nextbasecrm.step_definitions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.NextBaseCrmHomePage;
import com.nextbasecrm.pages.NextBaseCrmLoginPage;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NextBaseCrm_MessageAndComment_StepDefs {

    NextBaseCrmLoginPage nextBaseCrmLoginPage = new NextBaseCrmLoginPage();

    NextBaseCrmHomePage nextBaseCrmHomePage = new NextBaseCrmHomePage();

    Faker faker = new Faker();

    @Given("user navigates to nextBaseCrm home page with valid credentials")
    public void user_is_on_the_nextBaseCrm_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        //nextBaseCrmLoginPage.loginLink.click();
        nextBaseCrmLoginPage.userNameInput.sendKeys("helpdesk1@cybertekschool.com");
        nextBaseCrmLoginPage.passwordInput.sendKeys("UserUser");
        nextBaseCrmLoginPage.loginButton.click();

    }


    @When("user clicks the send message input box")
    public void user_clicks_the_send_message_input_box() {
        nextBaseCrmHomePage.sendMessageInputBox.click();

    }


    @And("user writes and send the message")
    public void userWritesAndSendTheMessage() {
        //BrowserUtils.sleep(2);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(nextBaseCrmHomePage.iframe));

        Driver.getDriver().switchTo().frame(nextBaseCrmHomePage.iframe);

        nextBaseCrmHomePage.writeMessageBox.sendKeys(faker.chuckNorris().fact());

        Driver.getDriver().switchTo().parentFrame();

        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(),10);
        wait2.until(ExpectedConditions.elementToBeClickable(nextBaseCrmHomePage.sendMessageButton));
        nextBaseCrmHomePage.sendMessageButton.click();

    }

    @Then("user check username")
    public void userCheckUsername() {
        Assert.assertTrue(nextBaseCrmHomePage.idName.isDisplayed());
        System.out.println("username = " + nextBaseCrmHomePage.idName.getText());
    }




    @When("user clicks first message's comment input box")
    public void user_clicks_first_message_s_comment_input_box() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(nextBaseCrmHomePage.getCommentBox));

        nextBaseCrmHomePage.getCommentBox.click();
    }
    @When("user writes the comment")
    public void user_writes_the_comment() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(nextBaseCrmHomePage.iframe));
        Driver.getDriver().switchTo().frame(nextBaseCrmHomePage.iframe);

        nextBaseCrmHomePage.writeCommentBox.sendKeys(faker.chuckNorris().fact());

    }
    @Then("user clicks the send comment button")
    public void user_clicks_the_send_comment_button() {
        Driver.getDriver().switchTo().parentFrame();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(nextBaseCrmHomePage.sendCommentButton));

        nextBaseCrmHomePage.sendCommentButton.click();
    }



}
