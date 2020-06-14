package com.example.ecom.myexample.best;

import java.util.Optional;

public class ArrayValidationUtils {

    public static final String ERROR_ARRAY_MUST_BE_NULL = "Array must be null";
    public static final String ARRAY_SIZE_MUST_BE_ONE = "Array size must be 'one'";
    public static final String ARRAY_INDEX_SIZE_EXCESS = "Array index size excess";
    public static final int INDEX_SIZE_ONE = 1;


    public static Optional<String> validateAndGetErrorMessage(int[] linearExample,
                                                              int indexSize) {

        final Optional<String> errorMessage = validateAndGetErrorMessage(
                linearExample
        );
        if (errorMessage.isPresent()) {
            return errorMessage;
        }

        final int linearExampleLength = linearExample.length;
        return checkIndexSize(
                indexSize,
                linearExampleLength
        );
    }

    public static Optional<String> validateAndGetErrorMessage(int[] linearExample) {
        // to check whether the array is empty or not
        if (linearExample == null) {
            return Optional.of(ERROR_ARRAY_MUST_BE_NULL);
        }
        // to check whether the array size at least one
        if (linearExample.length < INDEX_SIZE_ONE) {
            return Optional.of(ARRAY_SIZE_MUST_BE_ONE);
        }
        return Optional.empty();
    }

    public static Optional<String> checkIndexSize(final int indexSize,
                                                  final int linearExampleLength) {

        // check index size and arraySize
        if (linearExampleLength < indexSize) {
            return Optional.of(ARRAY_INDEX_SIZE_EXCESS);
        }
        return Optional.empty();
    }
}
