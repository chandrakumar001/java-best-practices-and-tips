package com.example.ecom.myexample.basic


import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LinearSearchSpec extends Specification {

    def "LinearSearch for #testStep"() {
        given: ""
        def actualResult = null
        when: "call method"
        actualResult = LinearSearch.linearSearch(
                linearExample as int[],
                target as int,
                linearExampleLength as int
        )
        then: "output matching"
        actualResult == expectedResult

        where:
        testStep                            | linearExample                     | target | linearExampleLength || expectedResult
        "The target is not found return -1" | Arrays.asList("1", "2", "4", "5") | "11"   | 4                   || -1
        "The target is found return 2"       | Arrays.asList("1", "2", "8", "4") | "8"    | 4                   || 2
    }
}
