package com.example.labb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Labb1Application {
	//https://api.themoviedb.org/3/movie/550?api_key=3000256a09175cd76b573f34c8245b50
	//3000256a09175cd76b573f34c8245b50

	public static void main(String[] args) {
		SpringApplication.run(Labb1Application.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
