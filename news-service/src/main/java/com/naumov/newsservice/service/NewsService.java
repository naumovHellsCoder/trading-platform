package com.naumov.newsservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:newsapi.properties")
public class NewsService {

    @Autowired
    private WebClient webClient;


    @Value(value = "${news-api.apiKey}")
    private String API_KEY;
    @Value(value = "${news-api.baseUrl}")
    private String baseUrl;

    public Mono<String> getNewsByWord(String word){
        String urlResult = baseUrl
                + "?q="
                + word
                + "&from=2022-11-09&sortBy=publishedAt&apiKey="
                + API_KEY;
        Mono<String> data = webClient
                .get()
                .uri(urlResult)
                .retrieve()
                .bodyToMono(String.class);
        return data;

    }

}
