package com.sitedosistema.qa.automation.webservices.config.factories;

import com.sitedosistema.qa.automation.webservices.config.pojo.CreateCardRequest;
import com.sitedosistema.qa.automation.webservices.config.pojo.UpdateCardRequest;
import org.apache.commons.lang3.RandomStringUtils;

import static com.sitedosistema.qa.automation.utils.Columns.DONE;
import static com.sitedosistema.qa.automation.utils.Columns.TO_DO;
import static com.sitedosistema.qa.automation.utils.StringUtils.getActualTime;

public class CardFactory {

    public CreateCardRequest getNewCard() {
        CreateCardRequest request = new CreateCardRequest();
        request.setName("API - Nome " + getActualTime());
        request.setDescription(RandomStringUtils.randomAlphanumeric(20));
        request.setListId(TO_DO);
        return request;
    }

    public UpdateCardRequest updateCardToDone(String cardId) {
        UpdateCardRequest request = new UpdateCardRequest();
        request.setCardId(cardId);
        request.setListId(DONE);
        return request;
    }
}
