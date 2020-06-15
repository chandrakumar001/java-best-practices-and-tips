package com.example.ecom;

public class ValidationUtils {

    private ValidationUtils() {
        throw new UnsupportedOperationException("ValidationUtil class");
    }


    public static void checkIndexSize(final String value,
                                      final String name,
                                      final boolean isIndexPosition,
                                      final int indexValue) {

        if (isIndexPosition && (value.length() <= indexValue)) {
            throw new IllegalArgumentException(name);
        }
    }
}