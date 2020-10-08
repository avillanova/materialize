package com.sitedosistema.qa.automation.utils;

public enum Columns {
    TO_DO("TODO", "5f7e36ee8af920703746894d"),
    IN_PROGRESS("In Progress", ""),
    DONE("Done", "5f7e36f5a76dd44e623105ea");

    private String listName;
    private String listId;

    Columns(String listName, String listId) {
        this.listName = listName;
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public String getListId(){
        return listId;
    }
}
