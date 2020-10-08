package com.sitedosistema.qa.automation.websites.pom.board;


import com.sitedosistema.qa.automation.utils.Columns;
import com.sitedosistema.qa.automation.webservices.config.pojo.CreateCardRequest;
import com.sitedosistema.qa.automation.websites.config.Tools;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.sitedosistema.qa.automation.utils.Columns.DONE;
import static com.sitedosistema.qa.automation.utils.Columns.TO_DO;
import static com.sitedosistema.qa.automation.websites.config.Hook.driver;
import static com.sitedosistema.qa.automation.websites.config.Tools.waitBy;
import static com.sitedosistema.qa.automation.websites.config.Urls.BOARD_PAGE;

public class BoardPage {
    private String cardName;

    @FindBy(how=How.XPATH,using = "//div[div/h2[text()='TODO']]//span[@class='list-card-title js-card-name']")
    private List<WebElement> elementsToDo;
    @FindBy(how = How.XPATH, using = "//textarea[@aria-label=\"TODO\"]//ancestor::div[@class=\"list js-list-content\"]//*[@class=\"js-add-another-card\"]")
    private WebElement addCardTodo;
    @FindBy(how=How.XPATH, using = "//*[@placeholder='Insira um título para este cartão...']")
    private WebElement inputCardName;
    @FindBy(how=How.XPATH,using = "//input[@value='Adicionar Cartão']")
    private WebElement addCardButton;
    @FindBy(how = How.XPATH, using = "//textarea[@class=\"field field-autosave js-description-draft description card-description\"]")
    private WebElement cardDesc;
    @FindBy(how=How.XPATH, using = "//*[@value='Salvar']")
    private WebElement saveCard;
    @FindBy(how=How.XPATH, using = "//a[@class='icon-md icon-close dialog-close-button js-close-window']")
    private WebElement closeCardButton;
    @FindBy(how=How.XPATH,using = "//div[div/h2[text()='Done']]//span[@class='list-card-title js-card-name']")
    private List<WebElement> elementsDone;
    @FindBy(how=How.XPATH,using = "//div[div/h2[text()='Done']]")
    private WebElement done;

    public BoardPage() {
        PageFactory.initElements(driver(), this);
    }

    public BoardPage acessBoard(){
        driver().get(BOARD_PAGE.getUrl());
        return this;
    }

    public BoardPage createCard(CreateCardRequest newCard) {
        cardName = newCard.getName();
        waitBy(addCardTodo).click();
        waitBy(inputCardName).sendKeys(cardName);
        waitBy(addCardButton).click();
        Tools.wait(1000);
        waitBy(driver().findElement(By.xpath("//span[contains(text(),'"+cardName+"')]"))).click();
        waitBy(cardDesc).sendKeys(newCard.getDescription());
        waitBy(saveCard).click();
        waitBy(closeCardButton).click();
        return this;
    }

    public BoardPage moveCardToDone(){
        Actions act = new Actions(driver());
        act.dragAndDrop(driver().findElement(By.xpath("//span[text()='"+cardName+"']")), waitBy(done));
        act.perform();
        Tools.wait(2000);
        return this;
    }

    public BoardPage checkIfCardIsInColumn(Columns column){
        if(column.equals(TO_DO)){
            for(WebElement e : elementsToDo){
                String text = e.getText();
                if(text.equals(cardName)) {
                    Assert.assertEquals(cardName, text);
                }
            }

        }else if(column.equals(DONE)){
            for(WebElement e : elementsDone){
                String text = e.getText();
                if(text.equals(cardName)) {
                    Assert.assertEquals(cardName, text);
                }
            }
        }
        return this;
    }


}
