package com.vivk.study.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 * Consuemr<T>:消费型接口
 *        void accept(T t);
 * Supplier<T>:供给型接口
 *       T get();
 * Function<T,R>:函数型接口
 *       R apply(T t);
 * Predicate<T>:断言型接口
 *       boolean test(T t);
 */
public class LambdaTest4 {
    //Consumer<T>消费型接口：
    @Test
    public void test1(){
        happy(10000,(m)-> System.out.println("国庆第二天，消费" + m + "元"));
    }
    public void  happy(double money, Consumer<Double> con){
        con.accept(money);
    }
    //Supplier<T>消费型接口：
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }
    //产生一些整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<num;i++){
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
    //Function<T,R> 函数型接口：
    //需求：用于处理字符串
    @Test
    public void test3(){
        String s = strHandler("\t\t\t\t不想出门  ", str -> str.trim());
        System.out.println(s);
    }
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }
    //Predicate<T>断言型接口：
    //需求：将满足的字符串放入集合中
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello", "www", "aaabbbccdd");
        List<String> strlist = filterStr(list, s -> s.length() > 3);
        for (String s : strlist) {
            System.out.print(s+",");
        }
    }
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                strList.add(s);
            }
        }
        return  strList;
    }
}
