package com.example.vendingmachine.input;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ReqInputMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();
    public ReqInputMapper () {
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    public Machine processInputJson(String fileName) throws IOException {
        return objectMapper.readValue(new File(fileName), Machine.class);
    }
}
