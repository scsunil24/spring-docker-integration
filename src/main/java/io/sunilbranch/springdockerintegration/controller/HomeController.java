package io.sunilbranch.springdockerintegration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/")
@RestController
public class HomeController {

    @GetMapping("message")
    public String message(){
        return "Welcome to Spring Boot Docker Integration !!!";
    }
}
