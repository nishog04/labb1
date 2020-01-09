package com.example.labb1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class Controller {

    private final String apiKey = "?api_key=3000256a09175cd76b573f34c8245b50";
    private String URL = "https://api.themoviedb.org/3/movie/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/movies")
    public String getTopRatedMovies(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                URL + "top_rated" + apiKey, HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/favorites")
    public String getFavoriteMovie(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                URL + "278" + apiKey, HttpMethod.GET, entity, String.class).getBody();
    }


}
