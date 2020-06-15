package com.example.ecom.jsonmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class jacksonJsonMapper implements JsonMapper {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public <T> T stringToObject(String jsonString, Class<T> clazz) {

        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
