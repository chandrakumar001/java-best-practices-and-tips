package com.example.ecom.myexample.best;

public class ArrayApproachExample {

    public static void main(String[] args) {
        int[] linearExample = {1, 4, 8, 11, 55, 6};
        // total element is 6
        // total Index is 5
        int findIndex = 99;

        final int indexNumber = findIndexNumber(
                linearExample,
                findIndex
        );
        System.out.println(indexNumber);

        // access indexNumber number
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
        getLinearExampleLength(linearExample);


        final int linearExampleLength = linearExample.length;
        // check index size and arraySize
        if (linearExampleLength < indexSize) {
            throw new IllegalArgumentException("Array index size excess");
        }

        return linearExample[indexSize];
    }

    public static int findIndexNumber(int[] linearExample,
                                      int findIndexNumber) {

        getLinearExampleLength(linearExample);

        final int linearExampleLength = linearExample.length;

        for (int index = 0; index < linearExampleLength; index++) {
            if (findIndexNumber == linearExample[index]) {
                return index;
            }
        }
        throw new IllegalArgumentException("Value is not found");
    }

    public static void getLinearExampleLength(int[] linearExample) {
        // to check whether the array is empty or not
        if (linearExample == null) {
            throw new IllegalArgumentException("Array must be null");
        }
        // to check whether the array size at least one
        if (linearExample.length < 1) {
            throw new IllegalArgumentException("Array size must be 'one'");
        }
    }
}
