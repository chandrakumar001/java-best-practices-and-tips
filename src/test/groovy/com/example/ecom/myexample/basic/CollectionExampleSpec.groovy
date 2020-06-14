package com.example.ecom.myexample.basic


import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CollectionExampleSpec extends Specification {

    def "fail-fast method basicIterator for #testStep"() {
        given: ""
        def actualResult = null
        def actualErrorMessage = null
        when: "call method"
        try {
            actualResult = CollectionExample1.basicIterator(
                    linearExample as List<String>,
                    findValue as String
            )
        } catch (UnsupportedOperationException e) {
            actualErrorMessage = e.getMessage()
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                                            | linearExample                     | findValue || expectedResult       | expectedErrorMessage
        "The value is not found"                            | Arrays.asList("1", "2", "4", "5") | "11"      || ["1", "2", "4", "5"] | null
        "The value is found(UnsupportedOperationException)" | Arrays.asList("1", "2", "3", "4") | "2"       || null                 | "remove"
    }

    def "fail-safe method basicIterator1 for #testStep"() {
        given: ""
        def actualResult = null

        when: "call method"
        actualResult = CollectionExample1.basicIterator1(
                linearExample as List<String>,
                findValue as String
        )
        then: "output matching"
        actualResult == expectedResult

        where:
        testStep                                            | linearExample                    | findValue || expectedResult
        "The value is not found"                            | ["1", "2", "4", "5"] as String[] | "11"      || ["1", "2", "4", "5"]
        "The value is found(UnsupportedOperationException)" | ["1", "2", "3", "4"] as String[] | "3"       || ["1", "2", "4"]
    }

    def "fail-fast method enhancedLoop for #testStep"() {
        given: ""
        def actualResult = null
        def actualErrorMessage = null

        when: "call method"
        try {
            actualResult = CollectionExample1.enhancedLoop(
                    linearExample as List<String>,
                    findValue as String
            )
        } catch (UnsupportedOperationException e) {
            actualErrorMessage = e.getMessage()
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                                            | linearExample                     | findValue || expectedResult       | expectedErrorMessage
        "The value is not found"                            | Arrays.asList("1", "2", "4", "5") | "11"      || ["1", "2", "4", "5"] | null
        "The value is found(UnsupportedOperationException)" | Arrays.asList("1", "2", "3", "4") | "2"       || null                 | "remove"
    }

    def "fail-fast method java8ForEach for #testStep"() {
        given: ""
        def actualResult = null
        def actualErrorMessage = null

        when: "call method"
        try {
            actualResult = CollectionExample1.java8ForEach(
                    linearExample as List<String>,
                    findValue as String
            )
        } catch (UnsupportedOperationException e) {
            actualErrorMessage = e.getMessage()
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                                            | linearExample                     | findValue || expectedResult       | expectedErrorMessage
        "The value is not found"                            | Arrays.asList("1", "2", "4", "5") | "11"      || ["1", "2", "4", "5"] | null
        "The value is found(UnsupportedOperationException)" | Arrays.asList("1", "2", "3", "4") | "2"       || null                 | "remove"
    }

    def "fail-fast method basicForLoop with Arrays.asList for #testStep"() {
        given: ""
        def actualResult = null
        def actualErrorMessage = null

        when: "call method"
        try {
            actualResult = CollectionExample1.basicForLoop(
                    linearExample as List<String>,
                    findValue as String
            )
        } catch (Exception e) {
            if (Exception instanceof UnsupportedOperationException) {
                actualErrorMessage = e.getMessage() //no error message
            }
        }
        then: "output matching"
        actualResult == expectedResult
        actualErrorMessage == expectedErrorMessage

        where:
        testStep                                            | linearExample                     | findValue || expectedResult       | expectedErrorMessage
        "The value is not found"                            | Arrays.asList("1", "2", "4", "5") | "11"      || ["1", "2", "4", "5"] | null
        "The value is found(UnsupportedOperationException)" | Arrays.asList("1", "2", "3", "4") | "2"       || null                 | null
    }

    def "fail-safe method basicForLoop with new arrayList #testStep"() {
        given: ""
        def actualResult = null

        when: "call method"
        actualResult = CollectionExample1.basicForLoop(
                linearExample as List<String>,
                findValue as String
        )
        then: "output matching"
        actualResult == expectedResult

        where:
        testStep                                            | linearExample | findValue || expectedResult
        "The value is not found"                            | getStrings()  | "11"      || ["1", "2", "3", "4", "5"]
        "The value is found(UnsupportedOperationException)" | getStrings()  | "2"       || ["1", "3", "4", "5", "6"]
    }

    static List<String> getStrings() {
        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        return myList;
    }

}
