package com.vivk.study.lambda;

import com.vivk.study.stream.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class LambdaTest3 {
    List<Employee> employees= Arrays.asList(
            new Employee("张三",18,2.45),
            new Employee("李四",19,21.45),
            new Employee("王无",38,241111.45),
            new Employee("赵八",88,2714477.45),
            new Employee("九九",28,774.45),
            new Employee("九九",88,714.45),
            new Employee("九九",61,744.45)
    );
    @Test
    public void test1(){
        Collections.sort(employees,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    //用于处理字符串
    @Test
    public void test2(){
        String trimStr = strHandler("\t\t\t国庆第二天    ", str -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("aaabbbccc", str -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("\t\t\t国庆第二天    ", str -> str.substring(3,5));
        System.out.println(newStr);

    }
    public String strHandler(String str,MyFunction mf){
        return  mf.getValue(str);
    }
    //需求：对于两个Long型数据进行处理
    @Test
    public void test3(){
        op(100L,200L,(x,y)->x+y);
        op(100L,200L,(x,y)->x*y);

    }
    public void op(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }

}
