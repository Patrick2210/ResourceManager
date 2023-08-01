package com.szaruga.myapp.myenum;

public enum MyStringsTest {
    API_ENDPOINT("/api"),
    MEMBERS_ENDPOINT("/members"),
    ITEMS_ENDPOINT("/items"),
    USER("user_resource"),
    USER_PASSWORD("mypassword"),
    MANAGER("manager_resource"),
    MANAGER_PASSWORD("mypassword123"),
    ADMIN("admin_resource"),
    ADMIN_PASSWORD("mypassword321");


    public final String myString;

    MyStringsTest(String myString) {
        this.myString = myString;
    }
}
