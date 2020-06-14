package com.example.ecom.myexample.best

import spock.lang.Specification

class ArithmeticExampleSpec extends Specification {

    def "#testStep : find division"() {

        given: ""
        def actualErrorMessage = null
        def actualResult = null

        when: "action"
        try {
            actualResult = ArithmeticExample.findDivision(
                    number1,
                    number2
            )
        } catch (Exception e) {
            actualErrorMessage = e.getMessage()
        }
        then: "matching"
        actualErrorMessage == expectedErrorMessage
        actualResult == expectedResult
        where:
        testStep              | number1 | number2 | expectedResult | expectedErrorMessage
        "Division zero"       | 1       | 0       | null           | "ArithmeticException occurred!"
        "Negative value zero" | 1       | -1      | null           | "ArithmeticException occurred!"
        "output1"             | 1       | 6       | 0              | null
        "output2"             | 2       | 6       | 0              | null
        "output3"             | 10      | 6       | 1              | null
        "output4"             | 6       | 6       | 1              | null
        "output5"             | 12      | 6       | 2              | null
        //Example:
        //  (2.3,1.0)
        // No signature of method:
        // Possible solutions: findDivision(int, int)

    }

    def "#testStep : find findDivision1"() {

        given: ""
        def actualErrorMessage = null
        def actualResult = null

        when: "action"
        try {
            actualResult = ArithmeticExample.findDivision1(
                    number1 as double,
                    number2 as double
            )
        } catch (Exception e) {
            actualErrorMessage = e.getMessage()
        }
        then: "matching"
        actualErrorMessage == expectedErrorMessage
        actualResult == expectedResult
        where:
        testStep  | number1 | number2 | expectedResult      | expectedErrorMessage
        "output4" | 1.5     | 1.0     | 1.5                 | null
        "output4" | 11      | 1.5     | 7.333333333333333   | null
        "output1" | 1       | 6       | 0.16666666666666666 | null
        "output2" | 2       | 6       | 0.3333333333333333  | null
        "output3" | 10      | 6       | 1.6666666666666667  | null
        "output4" | 6       | 6       | 1                   | null
        "output5" | 12      | 6       | 2                   | null
    }
}
