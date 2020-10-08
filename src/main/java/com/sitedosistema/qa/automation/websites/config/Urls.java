package com.sitedosistema.qa.automation.websites.config;

public enum Urls {
    LOGIN_PAGE("https://trello.com/login"),
    BOARD_PAGE("https://trello.com/b/f4zS4qgj/materialize-exemplo");

    private String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
