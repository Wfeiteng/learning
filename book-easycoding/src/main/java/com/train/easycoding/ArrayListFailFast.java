package com.train.easycoding;

import java.util.ArrayList;
import java.util.List;

public class ArrayListFailFast {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
       // list.add("four");
        for(String s: list){
            System.out.println("s:"+s);
            if("two".equals(s)){
                list.remove(s);
            }
        }

        System.out.println(list);
    }
}
