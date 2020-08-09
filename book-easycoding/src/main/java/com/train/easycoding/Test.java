package com.train.easycoding;

public class Test {
    public static void add(int a){
        a=a+1;
        System.out.println("add:"+a);
        if(a==3){
            return ;
        }
        add(a);
        System.out.println("add-after:"+(a-1));
    }

    public static void main(String[] args) {
        int a =1;
        add(a);
        System.out.println(a);
    }
}
