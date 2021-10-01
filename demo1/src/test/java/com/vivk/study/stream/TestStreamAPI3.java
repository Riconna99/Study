package com.vivk.study.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 终止操作
 *
 *
 * */
public class TestStreamAPI3 {
    List<Employee>employees=Arrays.asList(
            new Employee("张三",18,2.45, Employee.Status.BUSY),
            new Employee("李四",19,21.45, Employee.Status.BUSY),
            new Employee("王无",88,241111.45, Employee.Status.VOCATION),
            new Employee("赵八",48,2714477.45, Employee.Status.FREE),
            new Employee("九九",68,774.45,Employee.Status.FREE)
    );

    /**
     * 查找与匹配
     * allMatch---检查是否匹配所有元素
     * anyMathc---是否至少匹配一个元素
     * noneMatch--检查是否没有匹配所有元素
     * findFirst--返回第一个元素
     * findAny---返回当前流中的任意元素
     * count---返回流中元素的总个数
     * max---返回流中最大值
     * min---返回流中最小值
     *
     */
    @Test
    public void test1() {
        boolean b = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        boolean b1 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());

        Optional<Employee> any = employees.parallelStream()
                .filter((e) -> e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(any.get());
    }
    @Test
    public void test2() {
        long count = employees.stream()
                .count();
        System.out.println(count);

        Optional<Employee> max = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());

        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(min.get());


    }
}
