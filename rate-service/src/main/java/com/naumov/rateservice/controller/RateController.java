package com.naumov.rateservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rate/")
public class RateController {
    @GetMapping("/")
    public Object getMain(){
        return new Object();
    }
}
