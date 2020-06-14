package com.example.ecom.myexample.best;

import java.util.Optional;

public class ArrayApproach1Example {


    public static void main(String[] args) {
        int[] linearExample = {1, 4, 8, 11, 55, 6};
        // total element is 6
        // total Index is 5
        int findIndex = 0;

        final int indexNumber = findIndexNumber(
                linearExample,
                findIndex
        );
        System.out.println(indexNumber);

        // access index number
        final int indexSize = 3;
        final int indexValue = findIndexValue(
                linearExample,
                indexSize
        );
        System.out.println(indexValue);
    }

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
