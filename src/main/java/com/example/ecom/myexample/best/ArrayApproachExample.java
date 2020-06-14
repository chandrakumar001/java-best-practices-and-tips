package com.example.ecom.myexample.best;

import java.util.Optional;

public class ArrayApproachExample {


    public static int findIndexValue(final int[] linearExample,
                                     final int indexSize) {

        final Optional<String> errorMessage = ArrayValidationUtils.validateAndGetErrorMessage(
                linearExample,
                indexSize
        );
        if (errorMessage.isPresent()) {
            throw new IllegalArgumentException(errorMessage.get());
        }

        return linearExample[indexSize];
    }

    public static int findIndexNumber(int[] linearExample,
                                      int findIndexNumber) {

        final Optional<String> errorMessage = ArrayValidationUtils.validateAndGetErrorMessage(
                linearExample
        );
        if (errorMessage.isPresent()) {
            throw new IllegalArgumentException(errorMessage.get());
        }

        final int linearExampleLength = linearExample.length;

        for (int index = 0; index < linearExampleLength; index++) {
            if (findIndexNumber == linearExample[index]) {
                return index;
            }
        }
        throw new IllegalArgumentException("Value is not found");
    }
}
