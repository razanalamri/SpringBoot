package com.SchoolSystem.FirstSpringDemo.Controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value="Hello")
    public String returnStringHello() {
        return "Hello World";
    }

    @GetMapping(value="myDetails")
    public String printDetails(String name,String nationality) {
        name="Razan";
        nationality="Omani";
        return "My name: "+name+" and my nationality is :"+nationality;
    }
}
