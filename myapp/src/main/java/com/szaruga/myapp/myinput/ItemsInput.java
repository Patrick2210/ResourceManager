package com.szaruga.myapp.myinput;

import com.szaruga.myapp.entity.Items;

import java.time.LocalDateTime;

public class ItemsInput {
    public static Items itemOne(){
        return new Items("Resource 6",
                LocalDateTime.of(2023, 7, 18, 10, 30, 0),
                LocalDateTime.of(2023, 7, 18, 15, 45, 0),
                3,
                "Type A",
                "{\"key\": \"value\"}");
    }

    public static Items itemTwo(){
        return new Items ("Resource 5",
                LocalDateTime.of(2023, 7, 17, 14, 0, 0),
                LocalDateTime.of(2023, 7, 18, 12, 15, 0),
                3,
                "Type B",
                "{\"key2\": \"value2\"}");
    }
}
