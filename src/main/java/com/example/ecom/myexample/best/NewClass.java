package com.example.ecom.myexample.best;

public class NewClass {

    public static void main(String[] args) {
        // TODO code application logic here
        double[] tab = {1.2, 3.4, 0.0, 5.6};

        for (int i = 0; i < tab.length; i++) {
            tab[i] = 1.0 / tab[i];

            if (tab[i] == Double.POSITIVE_INFINITY ||
                    tab[i] == Double.NEGATIVE_INFINITY)
                throw new ArithmeticException("ArithmeticException occurred!");
        }
    }
}