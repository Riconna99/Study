package com.vivk.study.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.security.SecurityProperties;


import java.util.ArrayList;
import java.util.Arrays;
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
public class TestStreamAPI1 {
    @Test
    public void test1() {
        //1.通过Collection 系列集合提供的stream()或paralleStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //4.创建无线流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }
}
