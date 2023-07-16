package com.szaruga.myapp.service;

import com.szaruga.myapp.entity.Items;

import java.util.List;

public interface ItemsService {
    List<Items> findAll();

    Items findById(int theId);

    Items save (Items theItems);

    void deleteById(int theId);
}
