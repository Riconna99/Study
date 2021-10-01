package com.vivk.study.lambda;

import com.vivk.study.stream.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LambdaTest1 {
    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    //lambda表达式
    @Test
    public void test2(){
        Comparator<Integer> com1=  (x,y)-> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com1);
    }

    List<Employee> employees= Arrays.asList(
            new Employee("张三",18,2.45),
            new Employee("李四",19,21.45),
            new Employee("王无",38,241111.45),
            new Employee("赵八",48,2714477.45),
            new Employee("九九",28,774.45),
            new Employee("九九",58,714.45),
            new Employee("九九",61,744.45)
    );
    //需求：获取当前公司中员工年龄大于35的员工信息
    @Test
    public void test3(){
        List<Employee> list = filterEmployee(employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    public List<Employee> filterEmployee(List<Employee> list){
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if(emp.getAge()>35){
                emps.add(emp);
            }
        }
        return  emps;
    }
    //需求：获取当前公司中员工工资大于5000的员工信息
    public List<Employee> filterEmployee2(List<Employee> list){
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
            if(emp.getSalary()>5000){
                emps.add(emp);
            }
        }
        return  emps;
    }
    @Test
    public void test4(){
        List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("-----------------------------------------------");
        List<Employee> list2 = filterEmployee(employees, new FilterEmployeeBySalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }
    //优化方式1：策略设计模式
    public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp){
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp : list) {
           if(mp.test(emp)){
               emps.add(emp);
           }
        }
        return  emps;
    }
    //优化方式2：匿名内部类
    @Test
    public void test5(){
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee e) {
                return e.getSalary() < 5000;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    //优化方式3：Lambda表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() <= 500);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
    //优化方式4:Stream API
    @Test
    public void test7(){
        employees.stream()
                .filter((e)->e.getSalary()>=500)
                .limit(3)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
