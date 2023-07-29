package com.szaruga.myapp.myenum;

public enum MyStrings {
    ITEM_DELETE("Deleted item with id: "),
    MEMBER_DELETE("Deleted member with id: "),
    ASSOCIATED_ITEMS("Associated items: "),
    MEMBER("Member "),
    ITEM("Item"),
    DONE("Done!"),
    ID_NOT_FOUND(" id not found: ");
    public final String myString;

    MyStrings(String myString) {
        this.myString = myString;
    }
}