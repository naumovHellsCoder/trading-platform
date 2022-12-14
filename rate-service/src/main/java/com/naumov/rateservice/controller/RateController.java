package com.naumov.rateservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/rate/")
public class RateController {
    private final Logger logger = LoggerFactory.getLogger(RateController.class);
    @GetMapping("/")
    public Map<String, String> getMain(@RequestHeader Map<String, String> headers){
        System.out.println(headers);
        String data = headers.get("authorization");
        logger.info(data);
        return headers;
    }
}
