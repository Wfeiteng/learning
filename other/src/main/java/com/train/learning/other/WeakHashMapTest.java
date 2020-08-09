package com.train.learning.other;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<Integer, String> weak = new WeakHashMap<>();
        for(int i=1;i<10000;i++){
            weak.put(i,String.valueOf(i));
            if(i%100==0){
                System.gc();
                System.out.println(weak.size());
            }
        }
    }
}
