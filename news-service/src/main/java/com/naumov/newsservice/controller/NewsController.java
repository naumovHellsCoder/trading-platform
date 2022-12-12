package com.naumov.newsservice.controller;

import com.naumov.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/news/")
public class NewsController {
    private final NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }
    @GetMapping(path = "{news}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<String>getNewsForStock(@PathVariable String news){
        return newsService.getNewsByWord(news);
    }
}
