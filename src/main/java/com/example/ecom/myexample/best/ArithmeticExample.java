package com.example.ecom.myexample.best;

public class ArithmeticExample {

    public static void main(String[] args) {
        char  FirstVariable = 0;
        System.out.println(FirstVariable);
        int number1 = 3;
        int number2 = -1;
        int result = findDivision(number1, number2);
        System.out.println(result);
    }

    public static int findDivision(final int number1,
                                   final int number2) {
        if (number2 < 1) {
            throw new ArithmeticException("ArithmeticException occurred!");
        }
        return (number1 / number2);
    }

    public static double findDivision1(final double number1,
                                       final double number2) {
/*        if (number2 < 1) {
            throw new ArithmeticException("ArithmeticException occurred!");
        }*/
        if (number1 == Double.POSITIVE_INFINITY ||
                number1 == Double.NEGATIVE_INFINITY)
            throw new ArithmeticException("ArithmeticException occurred!");

        return (number1 / number2);
    }
}
