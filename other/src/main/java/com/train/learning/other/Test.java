package com.train.learning.other;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        Test test = new Test();

       System.out.println(test.sortString(Arrays.asList("hshaksdhqqkqwkasfa","shgjqijasjkdhajkcsnidh")));
    }
    public List<String> sortString(List<String> values){
        if(Objects.isNull(values)){
            return values;
        }
        List<String> subValue = new ArrayList<>();
        // 提取字符串
        for (String value: values){
            List<String> ans = getSubStr(value);
            if(!ans.isEmpty()){
                subValue.addAll(ans);
            }
        }
        // 排序
        Collections.sort(subValue);
        return subValue;
    }
    // a与s之间的字符串
    private  List<String> getSubStr(String str){
        if(Objects.isNull(str) ){
            return Collections.emptyList();
        }
        char[] value = str.toCharArray();
        List<String> subStrs = new ArrayList<>();
        int left=-1,right=-1;
        for (int i=0;i<value.length;i++){
            if(value[i]=='a'){
               left = i;
            }
            if(value[i]=='s'&&left!=-1){
                right =i;
                if(right>left+1){
                    subStrs.add(str.substring(left+1,right));
                }
                left = -1;
                right =-1;
            }
        }
        return subStrs;
    }
}
