package com.example.testinunit;

import com.example.testinunit.entity.Item;
import com.example.testinunit.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
      Item item = new Item(9L,"costam",23,23);
      itemService.retriveHardcodededItem(item);
       return item;
    }

    @GetMapping("/all")
    public List<Item> retriveThemALl(){
        return itemService.retriveAll();
    }

    @GetMapping("/one")
    public Item retriveOneItem(){
        return itemService.retriveOne();
    }
}
