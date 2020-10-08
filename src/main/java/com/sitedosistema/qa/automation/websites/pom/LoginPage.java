package com.sitedosistema.qa.automation.websites.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.sitedosistema.qa.automation.websites.config.Hook.driver;
import static com.sitedosistema.qa.automation.websites.config.Tools.waitBy;
import static com.sitedosistema.qa.automation.websites.config.Urls.LOGIN_PAGE;

public class LoginPage {
    @FindBy(how = How.ID, using = "user")
    private WebElement userInput;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInput;
    @FindBy(how = How.ID, using = "login")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//a[@href=\"/alexvillanova/boards\"]")
    private WebElement initialPage;

    public LoginPage() {
        PageFactory.initElements(driver(), this);
    }

    public LoginPage access(){
        driver().get(LOGIN_PAGE.getUrl());
        return this;
    }

    public LoginPage doLogin(String user, String pass){
        waitBy(userInput).sendKeys(user);
        waitBy(passwordInput).sendKeys(pass);
        waitBy(loginButton).click();
        return this;
    }
    public void checkInitialPage(){
        waitBy(initialPage);
    }
}
