package com.example.ecom.myexample.best;

import java.util.Optional;

public class LinearSearchExample {

    public static void main(String[] args) {
        int[] linearExample = {1, 4, 8, 11, 55, 6};
        // total element is 6
        // total Index is 5
        int findIndex = 99;

        //final int index = findIndex(linearExample, findIndex);
        // System.out.println(index);

/*        try {
            final int index = findIndex2(linearExample, findIndex);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
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
        // to check whether the array is empty or not
        if (linearExample == null) {
            throw new IllegalArgumentException("Array must be null");
        }
        final int linearExampleLength = linearExample.length;
        // to check whether the array size at least one
        if (linearExampleLength < 1) {
            throw new IllegalArgumentException("Array size must be 'one'");
        }
        // check index size and arraySize
        if (linearExampleLength < indexSize) {
            throw new IllegalArgumentException("Array index size excess");
        }

        return linearExample[indexSize];
    }

    public static int findIndex2(int[] linearExample,
                                 int findIndexNumber) throws IllegalArgumentException {
        // to check whether the array is empty or not
        if (linearExample == null) {
            throw new IllegalArgumentException("Array must be null");
        }
        final int linearExampleLength = linearExample.length;
        // to check whether the array size at least one
        if (linearExampleLength < 1) {
            throw new IllegalArgumentException("Array size must be 'one'");
        }

        for (int index = 0; index < linearExampleLength; index++) {
            if (findIndexNumber == linearExample[index]) {
                return index;
            }
        }
        throw new IllegalArgumentException("Value is not found");
    }

    public static Optional<String> findIndex1(int[] linearExample, int findIndexNumber) {
        // to check whether the array is empty or not
        if (linearExample == null) {
            return Optional.of("Array must be null");
        }
        final int linearExampleLength = linearExample.length;
        // to check whether the array size at least one
        if (linearExampleLength < 1) {
            return Optional.of("Array size must be 'one'");
        }

        for (int i : linearExample) {
            if (findIndexNumber == i) {
                return Optional.empty();
            }
        }
        return Optional.of("Value is not found");
    }

    public static int findIndexNumber(int[] linearExample, int findIndexNumber) {
        // to check whether the array is empty or not
        if (linearExample == null) {
            throw new IllegalArgumentException("Array must be null");
        }
        final int linearExampleLength = linearExample.length;
        // to check whether the array size at least one
        if (linearExampleLength < 1) {
            throw new IllegalArgumentException("Array size must be 'one'");
        }

        for (int index = 0; index < linearExampleLength; index++) {
            if (findIndexNumber == linearExample[index]) {
                return index;
            }
        }
        throw new IllegalArgumentException("Value is not found");
    }
}
