package com.example.testinunit;

import com.example.testinunit.entity.Item;
import com.example.testinunit.service.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemRepoTest {

    @Autowired
    private ItemRepository repository;

    @Test
    public void testFIndAll(){
        //currently there are 4 items in database
        // an .sql can be added to resources for testing purposes
        List<Item> items = repository.findAll();
        assertEquals(4,items.size());
    }
}
