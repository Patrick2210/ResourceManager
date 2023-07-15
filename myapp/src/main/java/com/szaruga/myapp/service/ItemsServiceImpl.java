package com.szaruga.myapp.service;

import com.szaruga.myapp.dao.ItemsRepository;
import com.szaruga.myapp.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService {

    private ItemsRepository itemsRepository;

    @Autowired
    public ItemsServiceImpl(ItemsRepository theItemsRepository) {
        itemsRepository = theItemsRepository;
    }

    @Override
    public List<Items> findAll() {
        return itemsRepository.findAll();
    }

    @Override
    public Items findById(int theId) {
        Optional<Items> result = itemsRepository.findById(theId);
        Items theItem;

        if (result.isPresent()) {
            theItem = result.get();
        } else {
            throw new RuntimeException("Didn't find employee id - " + theId);
            //TODO fix string
        }
        return theItem;
    }

    @Override
    public Items save(Items theItem) {
        return itemsRepository.save(theItem);
    }

    @Override
    public void deleteById(int theId) {
        itemsRepository.deleteById(theId);
    }
}
