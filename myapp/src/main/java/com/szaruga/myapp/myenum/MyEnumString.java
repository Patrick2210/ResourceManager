package com.szaruga.myapp.myenum;

public enum MyEnumString {
    ITEM_DELETE("Deleted item id - "),
    USER_DELETE("Deleted user id - "),
    MEMBER("Member "),
    ITEM("Item"),
    ID_NOT_FOUND(" id not found - ");
    public final String myString;

    MyEnumString(String myString) {
        this.myString = myString;
    }
}