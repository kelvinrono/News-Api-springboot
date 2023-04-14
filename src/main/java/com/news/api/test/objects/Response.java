package com.news.api.test.objects;

import java.util.ArrayList;
import java.util.Date;

public class Response {
    public class Article{
        public Source source;
        public String author;
        public String title;
        public String description;
        public String url;
        public String urlToImage;
        public String publishedAt;
        public String content;
    }

    public class Root{
        public String status;
        public int totalResults;
        public ArrayList<Article> articles;
    }

    public class Source{
        public String id;
        public String name;
    }

}
