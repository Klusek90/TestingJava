package com.example.testinunit.service;

import com.example.testinunit.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public String retriveHardcodededItem(Item item){
        itemRepository.save(item);
            return "ok";
    }

    public List<Item> retriveAll(){
        List<Item> list= itemRepository.findAll();
        for(Item item:list){
            item.setTotal(item.getQuantity() * item.getValue());
        }

        return list;
    }

    public Item retriveOne(){
            Item item = new Item (2L,"name",23,43);
        return item;
    }
}
