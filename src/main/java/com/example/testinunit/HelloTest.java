package com.example.testinunit;

import com.example.testinunit.entity.Item;
import com.example.testinunit.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {
    @Autowired
    ItemService itemService;
    @GetMapping("/hello")
    public String HelloTest(){
        return "hello my new test";
    }

    @GetMapping("/item")
    public Item getItem(){
        Item item = new Item(1L,"name", 12,23);
        String name = itemService.retriveHardcodededItem(item);
       return item;
    }
}
