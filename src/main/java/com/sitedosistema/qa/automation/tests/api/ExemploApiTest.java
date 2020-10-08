package com.sitedosistema.qa.automation.tests.api;

import com.sitedosistema.qa.automation.webservices.config.BaseApiTest;
import com.sitedosistema.qa.automation.webservices.config.pojo.CreateCardResponse;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class ExemploApiTest extends BaseApiTest {

    @Test
    public void exemploApiTest(){
        Response response = API.createCard(CARD_FACTORY.getNewCard());
        Assert.assertEquals(200, response.getStatusCode());
        String cardId = response.as(CreateCardResponse.class).getId();
        response = API.moveCardToDone(CARD_FACTORY.updateCardToDone(cardId));
        Assert.assertEquals(200, response.getStatusCode());
    }
}
