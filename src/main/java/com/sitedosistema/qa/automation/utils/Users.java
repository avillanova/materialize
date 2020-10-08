package com.sitedosistema.qa.automation.utils;

public enum Users {
    ALEX("generic@email.com", "genericPassword");


    Users(String user, String password) {
        this.user = user;
        this.password = password;
    }

    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
