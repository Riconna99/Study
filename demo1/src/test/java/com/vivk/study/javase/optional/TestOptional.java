package com.vivk.study.javase.optional;

import com.vivk.study.javase.stream.Employee;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TestOptional {
    /**
     * Optional 容器类的常用方法：
     * Optional.of(T t):创建一个Optional实例
     * Optional.empty():创建一个空的Optional实例
     * Optional.ofNullable(T t):若t不为null，创建Optional实例，否则创建空实例
     * isPresent():判断是否包含值
     * orElse(T t):如果调用对象包含值，返回该值，否则返回t
     * orElseGet(Supplier s):如果调用对象包含值，返回该值，否则返回s获取的值
     * map(Function f):如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
     * flatMap(Function mapper):与 map类似，要求返回值必须是Optional
     */
    @Test
    public void test4(){
        Optional<Employee> op = Optional.ofNullable(new Employee("张三", 18, 8888.66, Employee.Status.BUSY));
//        Optional<String> str = op.map((e) -> e.getName());
//        System.out.println(str.get());
        Optional<String> s = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(s.get());
    }

    @Test
    public void test3(){
        Optional<Employee> employee = Optional.ofNullable(null);
        /*if (employee.isPresent()){
            System.out.println(employee.get());
        }
        Employee emp = employee.orElse(new Employee("张三", 18, 888.888, Employee.Status.FREE));
        System.out.println(emp);*/
        Employee emp = employee.orElseGet(()-> new Employee());
        System.out.println(emp);
    }
    @Test
    public void test2(){
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }
    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(new Employee());
        Employee emp = op.get();
        System.out.println(emp);
    }
    @Test
    public void test5(){
        Man man = new Man();

        String name = getGodnessName(man);
        System.out.println(name);
    }

    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man){
        if(man != null){
            Godness g = man.getGod();

            if(g != null){
                return g.getName();
            }
        }

        return "杨幂";
    }

    //运用 Optional 的实体类
    @Test
    public void test6(){
        Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));

        Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
        String name = getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("杨幂"))
                .getName();
    }
}



