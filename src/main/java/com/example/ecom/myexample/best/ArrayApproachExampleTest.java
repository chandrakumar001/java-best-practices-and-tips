package com.example.ecom.myexample.best;

public class ArrayApproachExampleTest {

    public static void main(String[] args) {
        int[] linearExample = {1, 4, 8, 11, 55, 6};
        // total element is 6
        // total Index is 5
        int findIndex = 99;

        final int indexNumber = ArrayApproachExample.findIndexNumber(
                linearExample,
                findIndex
        );
        System.out.println(indexNumber);

        // access indexNumber number
        final int indexSize = 3;
        final int indexValue = ArrayApproachExample.findIndexValue(
                linearExample,
                indexSize
        );
        System.out.println(indexValue);


    }
}
