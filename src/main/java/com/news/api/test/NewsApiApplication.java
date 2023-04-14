package com.news.api.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class NewsApiApplication {



	@Bean
	WebClient.Builder webClient() {

		return WebClient.builder();
	}



	public static void main(String[] args) {
		SpringApplication.run(NewsApiApplication.class, args);

		//String api_key ="b738bd4e5c9745729671e424d00eaaf1";

	
	}

}
