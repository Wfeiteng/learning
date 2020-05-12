package com.train.easycoding;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        String[] stringArray = {"1", "2", "3"};
        List<String> stringList = Arrays.asList(stringArray);
        stringList.set(1, "aa");
        System.out.println("stringList:" + stringList.get(1));
        System.out.println("stringArray:" + stringArray[1]);

    }
}
