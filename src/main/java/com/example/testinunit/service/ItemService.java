package com.example.testinunit.service;

import com.example.testinunit.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public String retriveHardcodededItem(Item item){
        itemRepository.save(item);
            return "ok";
    }

}
