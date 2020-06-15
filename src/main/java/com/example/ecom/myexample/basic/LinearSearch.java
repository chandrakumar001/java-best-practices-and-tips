package com.example.ecom.myexample.basic;

public class LinearSearch {


    /*
     * example:
     * @Param  values[] array with all the values
     * @Param  target value to be found
     * @Param  length total number of elements in the array
     */
    public static int linearSearch(final int[] values,
                            final int target,
                            final int length) {

        for (int i = 0; i < length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
