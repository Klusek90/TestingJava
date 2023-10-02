package com.example.testinunit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTest {

    @GetMapping("/hello")
    public String HelloTest(){
        return "hello my new test";
    }
}
