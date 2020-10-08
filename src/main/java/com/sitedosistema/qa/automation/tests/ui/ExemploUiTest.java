package com.sitedosistema.qa.automation.tests.ui;

import com.sitedosistema.qa.automation.utils.Columns;
import com.sitedosistema.qa.automation.websites.config.BaseUiTest;
import com.sitedosistema.qa.automation.websites.pom.LoginPage;
import com.sitedosistema.qa.automation.websites.pom.board.BoardPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.sitedosistema.qa.automation.utils.Columns.DONE;
import static com.sitedosistema.qa.automation.utils.Columns.TO_DO;
import static com.sitedosistema.qa.automation.utils.Users.ALEX;
import static com.sitedosistema.qa.automation.websites.config.Hook.quit;
import static com.sitedosistema.qa.automation.websites.config.Hook.setUp;


public class ExemploUiTest extends BaseUiTest {

    @Before
    public void before(){
        setUp();
        LoginPage loginPage = new LoginPage();
        loginPage.access();
        loginPage.doLogin(ALEX.getUser(), ALEX.getPassword());
        loginPage.checkInitialPage();
    }

    @After
    public void after(){
        quit();
    }

    @Test
    public void exemploUiTest(){
        BoardPage board = new BoardPage();
        board.acessBoard()
                .createCard(FACTORY.getNewCard())
                .checkIfCardIsInColumn(TO_DO)
                .moveCardToDone()
                .checkIfCardIsInColumn(DONE);
    }
}
