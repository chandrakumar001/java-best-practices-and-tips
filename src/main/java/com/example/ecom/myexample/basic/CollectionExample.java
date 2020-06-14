package com.example.ecom.myexample.basic;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectionExample {

    public static void main(String[] args) {
        // List<String> name = List.of("chandra", "ok", null);
        List<String> name1 = Arrays.asList("ok", null);
        forEach(null);
    }

    public static List<String> forEach1(List<String> name) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("List must be null");
        }
        return name.stream()
                .filter(Objects::nonNull)  //avoid null value
                .collect(Collectors.toList());
    }

    public static List<String> forEach(List<String> name) {

        if (CollectionUtils.isEmpty(name)) {
            throw new IllegalArgumentException("List must be null");
        }
        return name.stream()
                .filter(Objects::nonNull)  //avoid null value
                .collect(Collectors.toList());
    }
}
