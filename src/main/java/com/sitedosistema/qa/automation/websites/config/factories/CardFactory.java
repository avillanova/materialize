package com.sitedosistema.qa.automation.websites.config.factories;

import com.sitedosistema.qa.automation.webservices.config.pojo.CreateCardRequest;
import org.apache.commons.lang3.RandomStringUtils;

import static com.sitedosistema.qa.automation.utils.Columns.TO_DO;
import static com.sitedosistema.qa.automation.utils.StringUtils.getActualTime;

public class CardFactory {

    public CreateCardRequest getNewCard() {
        CreateCardRequest request = new CreateCardRequest();
        request.setName("UI - Nome " + getActualTime());
        request.setDescription(RandomStringUtils.randomAlphanumeric(20));
        request.setListId(TO_DO);
        return request;
    }
}
