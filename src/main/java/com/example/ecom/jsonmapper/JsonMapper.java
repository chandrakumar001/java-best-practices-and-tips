package com.example.ecom.jsonmapper;

public interface JsonMapper {

    <T> T stringToObject(String jsonString, Class<T> clazz);
}
