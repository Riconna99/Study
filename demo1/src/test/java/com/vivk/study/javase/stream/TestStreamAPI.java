package com.vivk.study.javase.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI {
    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 给定【1,2,3,4,5】，应该返回【1,4,9,16,25】.
     *
     */
    @Test
    public void test1(){
        Integer[] num = {1, 2, 3, 5, 4};
        Arrays.stream(num)
                .map((x)->x*x)
                .forEach(System.out::println);
    }
    /**
     * 2.怎样用map和reduce方法数一数流中有多少个Emplyee？
     *
     */
    List<Employee> employees=Arrays.asList(
            new Employee("张三",18,2.45, Employee.Status.BUSY),
            new Employee("李四",19,21.45, Employee.Status.BUSY),
            new Employee("王无",88,241111.45, Employee.Status.VOCATION),
            new Employee("赵八",48,2714477.45, Employee.Status.FREE),
            new Employee("九九",68,774.45,Employee.Status.FREE)
    );
    @Test
    public void  test2(){
        Optional<Integer> count = employees.stream()
                .map((e) -> 1)
                .reduce(Integer::sum);
        System.out.println(count.get());
    }
}
