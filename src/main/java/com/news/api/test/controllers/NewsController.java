package com.news.api.test.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.news.api.test.objects.Response;
import com.news.api.test.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private WebClient.Builder webClient;

    RestTemplate restTemplate=new RestTemplate();
    @GetMapping("getAllNews")
    public Object getAllNews() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();

//        Object newsInfo = webClient.build()
//                .get()
//                .uri("https://newsapi.org/v2/everything?q=Apple&from=2023-04-03&sortBy=popularity&apiKey=b738bd4e5c9745729671e424d00eaaf1")
//                .retrieve()
//                .bodyToMono(News.class)
//                .block();
        ResponseEntity<String> response=restTemplate.getForEntity("https://newsapi.org/v2/everything?q=Apple&from=2023-04-03&sortBy=popularity&apiKey=b738bd4e5c9745729671e424d00eaaf1",String.class);
        JsonNode jsonNode = om.readTree(String.valueOf(response.getBody()));

//        Response.Root root = om.readValue(response, Response.Root.class);

        System.out.println(jsonNode);
        return jsonNode;
//        return newsService.findAllNews();
    }

}
