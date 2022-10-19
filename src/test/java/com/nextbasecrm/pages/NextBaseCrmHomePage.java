package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NextBaseCrmHomePage {

    public NextBaseCrmHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='feed-add-post-micro-title']")
    public WebElement sendMessageInputBox;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@style='min-height: 184px;']")
    public WebElement writeMessageBox;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendMessageButton;


    @FindBy(xpath = "(//a[.='Add comment'])[1]")
    public WebElement getCommentBox;


    @FindBy(xpath = "//body[@style='min-height: 84px;']")
    public WebElement writeCommentBox;

    @FindBy(xpath = "//button[contains(@id, 'submit_blog')]")
    public WebElement sendCommentButton;

    @FindBy(id = "user-name")
    public WebElement idName;



}
