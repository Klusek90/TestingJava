package com.example.testinunit;

import com.example.testinunit.entity.Item;
import com.example.testinunit.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloTest.class)
class HelloTestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean   //service mocking
    private ItemService itemService;

    @Test
    public void hello_word_basic() throws  Exception{
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("hello my new test"))
                .andReturn();
        assertEquals("hello my new test",result.getResponse().getContentAsString());
    }

    @Test
    public void ItemService_check() throws  Exception{

        when(itemService.retriveOne()).thenReturn(new Item (2l,"Bill",23,43));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/one")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 2, \"name\": \"Bill\", \"value\": 23,\"quantity\": 43}"))
                .andReturn();
    }

    @Test
    public void retriveAllITemsTest() throws  Exception{
        //testing all by creating arry and compare it with array
        when(itemService.retriveAll()).thenReturn(
                Arrays.asList(new Item (2l,"Bill",23,43),
                              new Item (3l,"Hoe",30,20)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                                                      //sequence not matter
                .andExpect(content().json("[{\"id\": 3, \"name\": \"Hoe\", \"value\": 30,\"quantity\": 20}," +
                                                     "{\"id\": 2, \"name\": \"Bill\", \"value\": 23,\"quantity\": 43}]"))
                .andReturn();
    }

}