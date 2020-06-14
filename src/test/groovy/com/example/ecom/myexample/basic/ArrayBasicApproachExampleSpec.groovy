package com.example.ecom.myexample.basic

import com.example.ecom.myexample.basic.ArrayBasicApproachExample
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ArrayBasicApproachExampleSpec extends Specification {

    def "#testStep : findIndexNumber"() {
        given: "given index value out size"
        def actualResult = null
        def actualErrorMessage = null

        when: "call method"
        try {
            actualResult = ArrayBasicApproachExample.findIndexNumber(
                    linearExample,
                    findIndexNumber
            )
        } catch (Exception e) {
            actualErrorMessage = e.getMessage()
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                           | linearExample      | findIndexNumber | expectedResult | expectedErrorMessage
        "Array is null"                    | null               | 0               | null           | "Array must be null"
        "Array is empty"                   | [] as int[]        | 0               | null           | "Array size must be 'one'"
        "Array,The findValue is not found" | [1] as int[]       | 11              | null           | "Value is not found"
        "Array,The findValue is not found" | [1, 2, 3] as int[] | 11              | null           | "Value is not found"
        "Array,The findValue is found"     | [1, 8, 3] as int[] | 8               | 1              | null
        // Java Array NegativeArraySize will be allowed
        // Example:
        //      new int[-1]

    }

    def "#testStep : findIndexValue"() {
        given: "given index value out size"
        def actualResult = null
        def actualErrorMessage = null

        when: "call method"
        try {
            actualResult = ArrayBasicApproachExample.findIndexValue(
                    linearExample,
                    findIndexNumber
            )
        } catch (Exception e) {
            actualErrorMessage = e.getMessage()
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                       | linearExample      | findIndexNumber | expectedResult | expectedErrorMessage
        "Array is null"                | null               | 0               | null           | "Array must be null"
        "Array is empty"               | [] as int[]        | 0               | null           | "Array size must be 'one'"
        "Array index size excess"      | [1] as int[]       | 11              | null           | "Array index size excess"
        "Array,The findValue is found" | [1, 8, 3] as int[] | 1               | 8              | null
        // Java Array NegativeArraySize will be allowed
        // Example:
        //      new int[-1]

    }
}
