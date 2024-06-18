package com.mohanadhilles.demotest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @RequestMapping("/")
    public String greaString()
    {
        return "Hello Wrold!";
    }

   
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping(value = "/{name}")
    public String withRequest(@PathVariable String name)
    {
        return String.format("welcome %s to", name);

    }
}
