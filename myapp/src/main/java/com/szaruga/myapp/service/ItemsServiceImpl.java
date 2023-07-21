package com.szaruga.myapp.service;

import com.szaruga.myapp.dao.ItemsRepository;
import com.szaruga.myapp.entity.Items;
import com.szaruga.myapp.myenum.MyStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Items> findAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public Items findItemById(int theId) {
        Optional<Items> result = itemsRepository.findById(theId);
        Items theItem;

        if (result.isPresent()) {
            theItem = result.get();
        } else {
            throw new RuntimeException(MyStrings.ITEM.myString
                    + MyStrings.ID_NOT_FOUND.myString + theId);
        }
        return theItem;
    }

    @Override
    @Transactional
    public Items saveItem(Items theItem) {
        return itemsRepository.save(theItem);
    }

    @Override
    @Transactional
    public void deleteItemById(int theId) {
        itemsRepository.deleteById(theId);
    }
}
