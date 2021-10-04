package com.vivk.study.javase.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream 的三个步骤：
 * 1.创建stream
 *
 * 2.中间操作
 *
 * 3.终止操作（终端操作）
 *
 *
 * */
public class TestStreamAPI2 {
    List<Employee>employees=Arrays.asList(
            new Employee("张三",18,2.45),
            new Employee("李四",19,21.45),
            new Employee("王无",88,241111.45),
            new Employee("赵八",48,2714477.45),
            new Employee("九九",68,774.45),
            new Employee("九九",68,774.45),
            new Employee("九九",68,774.45)
    );

    /**
     *  筛选与切片
     *  filter ---接受Lamdba，从流中排出某些元素。
     *  limit ---截断流，使其元素不超过给定数量。
     *  skip(n) ---返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流。与limit(n)互补
     *  distinct ---筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    //内部迭代：迭代操作由Stream API完成
    @Test
    public void test1() {
        //中间操作：不会执行任何操作
        Stream<Employee> stream = employees.stream()
                .filter((e) -> {
                    System.out.println("Stream api 的中间操作");
                    return e.getAge()>20;
                });
        //终止操作：一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);
    }
    //外部迭代：
    public void test2(){
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test3(){
        employees.stream()
                .filter((e)->{
                    System.out.println("短路");
                    return e.getSalary()>5000;
                })
                .limit(2)
                .forEach(System.out::println);
    }
    @Test
    public void test4(){
        employees.stream()
                .filter((e)->e.getSalary()>500)
                .skip(1)
                .forEach(System.out::println);
    }
    @Test
    public void test5(){
        employees.stream()
                .filter((e)->e.getSalary()>500)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }
    /***
     *
     * 映射
     * map---接受Lamdba，将元素转成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     *
     *
     *  flatMap---接收一个函数作为参数，将其中的每个值都换成另一个流，然后把所有流连成一个流
     *
     */
    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .map((str)->str.toUpperCase())
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestStreamAPI2::filterCharacter);//{{a,a,a},{b,b,b}}将每一个流加入流中
        streamStream.forEach((sm)->{
            sm.forEach(System.out::println);
        });
        System.out.println("--------------------------------------------------");
        Stream<Character> characterStream = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);//{a,a,a,b,b,b}将流中每个字母加入流中
        characterStream.forEach(System.out::println);
    }
    public static Stream<Character> filterCharacter(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character ch: str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }
    @Test
    public void test7(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        ArrayList list2 = new ArrayList();
        list2.add(22);
        list2.add(11);
        list2.add(list);
        list2.addAll(list);
        System.out.println(list2);
    }
    /**
     *  排序
     *  sorted() --自然排序(Comparable)
     *  sorted(Comparator com)---定制排序(Comparator)
     *
     *
     * */
    @Test
    public void test8() {
        List<String> list = Arrays.asList("ccc", "ddd", "aaa", "bbb", "eee");
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        employees.stream()
                .sorted((e1,e2)->{
                    if(e1.getAge().equals(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else {
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }
}


















