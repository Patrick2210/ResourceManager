package com.szaruga.myapp.service;

import com.szaruga.myapp.entity.Items;

import java.util.List;

public interface ItemsService {
    List<Items> findAllItems();

    Items findItemById(int theId);

    Items saveItem (Items theItems);

    void deleteItemById(int theId);
}
