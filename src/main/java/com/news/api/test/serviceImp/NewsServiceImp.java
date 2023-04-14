package com.news.api.test.serviceImp;

import com.news.api.test.models.News;
import com.news.api.test.repository.NewsRepository;
import com.news.api.test.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class NewsServiceImp implements NewsService {

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private NewsRepository newsRepository;
    @Override
    public List<News> findAllNews() {
        return newsRepository.findAll();
    }


    @Override
    public Object saveAllNews() {
        Object newsInfo = webClient.build()
                .get()
                .uri("https://newsapi.org/v2/everything?q=Apple&from=2023-04-13&sortBy=popularity&apiKey=b738bd4e5c9745729671e424d00eaaf1")
                .retrieve()
                .bodyToMono(News.class)
                .block();

        System.out.println(newsInfo.toString());
//        newsRepository.save(newsInfo);

        return newsInfo;
    }


}
