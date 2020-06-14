package com.example.ecom.myexample.best

import com.example.ecom.myexample.basic.CollectionExample
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CollectionExampleSpec extends Specification {

    def "#testStep : findIndexNumber"() {
        given: "given index value out size"
        def actualResult = null
        def actualErrorMessage = null

        when: "call method"
        try {
            actualResult = CollectionExample.forEach(
                    linearExample as List<String>
            )
        } catch (Exception e) {
            actualErrorMessage = e.getMessage()
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                           | linearExample                       || expectedResult | expectedErrorMessage
        "Array is null"                    | null                                || null           | "List must be null"
        "Array is empty"                   | [] as List<String>                  || null           | "List must be null"
        "Array,The findValue is not found" | ["ok"] as List<String>              || ["ok"]         | null
        "Array,The findValue is not found" | ["ok", "new", null] as List<String> || ["ok", "new"]  | null
    }

    def "#testStep : findIndexNumber1"() {
        given: "given index value out size"
        def actualResult = null
        def actualErrorMessage = null

        when: "call method"
        try {
            actualResult = CollectionExample.forEach1(
                    linearExample as List<String>
            )
        } catch (Exception e) {
            actualErrorMessage = e.getMessage()
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                               | linearExample                       || expectedResult | expectedErrorMessage
        "List is null"                         | null                                || null           | "List must be null"
        "List is empty"                        | [] as List<String>                  || null           | "List must be null"
        "List contains single element"         | ["ok"] as List<String>              || ["ok"]         | null
        "List contains many element with null" | ["ok", "new", null] as List<String> || ["ok", "new"]  | null
    }
}
