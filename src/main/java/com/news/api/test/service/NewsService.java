package com.news.api.test.service;

import com.news.api.test.models.News;

import java.util.List;

public interface NewsService {

   List<News> findAllNews();
    Object saveAllNews();
}
