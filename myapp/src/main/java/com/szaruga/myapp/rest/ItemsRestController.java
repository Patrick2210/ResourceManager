package com.szaruga.myapp.rest;

import com.szaruga.myapp.entity.Items;
import com.szaruga.myapp.myenum.MyStrings;
import com.szaruga.myapp.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemsRestController {
    private ItemsService itemsService;

    @Autowired
    public ItemsRestController(ItemsService theItemsService) {
        itemsService = theItemsService;
    }

    @GetMapping("/items")
    public List<Items> findAll() {
        return itemsService.findAllItems();
    }

    @GetMapping("/items/{itemsId}")
    public Items getItems(@PathVariable int itemsId) {
        Items theItems = itemsService.findItemById(itemsId);
        if (theItems == null) {
            throw new RuntimeException(MyStrings.ITEM.myString +
                    MyStrings.ID_NOT_FOUND.myString + itemsId);
        }
        return theItems;
    }

    @PostMapping("/items")
    public Items addItem(@RequestBody Items theItem) {
        theItem.setId(0);
        return itemsService.saveItem(theItem);
    }

    @DeleteMapping("/items/{itemsId}")
    public String deleteItem(@PathVariable int itemsId) {
        Items theItem = itemsService.findItemById(itemsId);
        if (theItem == null) {
            throw new RuntimeException(MyStrings.ITEM.myString +
                    MyStrings.ID_NOT_FOUND.myString + itemsId);
        }
        itemsService.deleteItemById(itemsId);
        return MyStrings.ITEM_DELETE.myString + itemsId;
    }
}
