package com.example.labb1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@RestController
public class Controller {

    private final String apiKey = "?api_key=3000256a09175cd76b573f34c8245b50";
    private final String url = "https://api.themoviedb.org/3/movie/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/movies")
    public String getTopRatedMovies() throws IOException {

        String jsonInput = restTemplate.getForObject(url + "top_rated" + apiKey, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Object json = mapper.readValue(jsonInput, Object.class);
        String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        return jsonOutput;
    }

    @RequestMapping(value = "/favorites")
    public String getFavoriteMovie() throws JsonProcessingException {

        String jsonInput = restTemplate.getForObject(url + "278" + apiKey, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Object json = mapper.readValue(jsonInput, Object.class);
        String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        return jsonOutput;
    }
}
