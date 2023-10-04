package com.example.testinunit;

import com.example.testinunit.entity.Item;
import com.example.testinunit.service.ItemRepository;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
//SpringBoottest allow to launch the whole application and searching thought the packages for @SpringBoot
//Random port allows to do it with not messing up with current ports that applicaiton is launch
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemRepoTest {

    //spring boot class allowing to make calls (?)
    @Autowired //as its already configure on the same port
    private TestRestTemplate restTemplate;
    @Autowired
    private ItemRepository repository;

    @Test
    public void testFIndAll(){
        //currently there are 4 items in database
        // an .sql can be added to resources for testing purposes
        List<Item> items = repository.findAll();
        assertEquals(4,items.size());
    }


    //integration test

    @Test
    public void contextLoad() throws JSONException {
        //geting entire thing as String class
        String responed =this.restTemplate.getForObject("/all" ,String.class);
        //strict 'false' allows to make check them in no order, while 'true' check the in order
        JSONAssert.assertEquals("[{id:2},{id:4},{id:16},{id: 1}]", responed, false);
    }

}
