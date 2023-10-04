package com.example.testinunit.service;

import com.example.testinunit.entity.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {


    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

    @Test
    public void  calculateSum(){
        //populating repository without need to connecting to database
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item (2l,"Bill",10,10),
                                                                new Item (3l,"Hoe",20,20)));
        List<Item> items = itemService.retriveAll();
        assertEquals(100, items.get(0).getTotal());
        assertEquals(400, items.get(1).getTotal());
    }

}