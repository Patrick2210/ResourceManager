package com.szaruga.myapp.myinput;

import com.szaruga.myapp.entity.Members;

import java.time.LocalDateTime;

public class MembersInput {

    public static Members memberOne (){
        return new Members("JohnDoe", "John", "Doe",
                LocalDateTime.of(2023, 7, 18, 10, 30, 0),
                LocalDateTime.of(2023, 7, 18, 15, 45, 0),
                "User");
    }
}
