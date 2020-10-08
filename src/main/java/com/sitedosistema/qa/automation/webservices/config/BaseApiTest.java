package com.sitedosistema.qa.automation.webservices.config;

import com.sitedosistema.qa.automation.webservices.Api;
import com.sitedosistema.qa.automation.webservices.config.factories.CardFactory;

public abstract class BaseApiTest {
    protected static final Api API = new Api();
    protected static final CardFactory CARD_FACTORY = new CardFactory();
}
