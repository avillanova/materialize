package com.sitedosistema.qa.automation.webservices.config;

public enum Endpoints {
    BASE_URL("https://api.trello.com/1/"),
    CREATE_CARD("cards?name={name}&desc={desc}&idList={listId}&{auth}"),
    UPDATE_CARD("cards/{cardId}?idList={listId}&{auth}");

    private String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
