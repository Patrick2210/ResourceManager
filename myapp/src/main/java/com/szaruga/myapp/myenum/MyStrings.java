package com.szaruga.myapp.myenum;

public enum MyStrings {
    SAVING_MEMBER("Saving member: "),
    THE_ITEM("The item: "),
    ITEM_DELETE("Deleted item id - "),
    USER_DELETE("Deleted user id - "),
    MEMBER("Member "),
    ITEM("Item"),
    DONE("Done!"),
    ID_NOT_FOUND(" id not found - ");
    public final String myString;

    MyStrings(String myString) {
        this.myString = myString;
    }
}