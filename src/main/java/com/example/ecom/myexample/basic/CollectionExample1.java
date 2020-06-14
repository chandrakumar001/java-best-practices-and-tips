package com.example.ecom.myexample.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionExample1 {

    public static void main(String[] args) {
        List<String> myList = getStrings();
        //List<String> myList = Arrays.asList("1", "2", "3", "4");
        basicForLoop(myList, "2");

    }

    public static List<String> getStrings() {
        List<String> myList = new ArrayList<>();


        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        return myList;
    }

    public static List<String> basicIterator(List<String> myList,
                                             String findValue) {

        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals(findValue))  //UnsupportedOperationException
                myList.remove(value); // because we are calling remove() directly on the list object.
        }
        return myList;
    }

    public static List<String> basicIterator1(List<String> myList,
                                              String findValue) {

        Iterator<String> it = myList.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals(findValue))
                it.remove();//because we are not calling remove() directly on the list object.
        }
        return myList;
    }

    public static List<String> enhancedLoop(List<String> names,
                                            String findValue) {

        for (String name : names) {
            if (name.equals(findValue)) {
                names.remove(name); //java.util.ConcurrentModificationException
            }
        }
        return names;
    }

    public static List<String> java8ForEach(List<String> myList,
                                            String findValue) {
        myList.forEach(name -> {
            if (name.equals(findValue)) {
                myList.remove(name); //java.util.ConcurrentModificationException
            }
        });
        return myList;
    }

    public static List<String> basicForLoop(List<String> myList,
                                            String findValue) {

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
            if (myList.get(i).equals(findValue)) {
                myList.remove(i); // no ConcurrentModificationException
                i--; //To avoid override the value
                myList.add("6"); // no ConcurrentModificationException
            }
        }
        return myList;
    }
}
