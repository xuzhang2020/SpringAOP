package com.bfs.logindemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {

        Processor stringProcessor = (String str) -> str.length();

        //LambdaTest test = new LambdaTest();
        //test.happyTime();
        happyTime(500, money->System.out.println("life is hard"+money));

        List<String> list = Arrays.asList("london","newyork","paris","tokyo");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("o");
            }
        });
        List<String> filterStrs2 = filterString(list, s -> s.contains("o"));

        System.out.println(filterStrs2);
    }
    public static void happyTime(double money, Consumer<Double> con){
        con.accept(money);

    }

    public static ArrayList<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for(String s: list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}