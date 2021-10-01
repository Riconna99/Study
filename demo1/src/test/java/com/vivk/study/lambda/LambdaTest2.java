package com.vivk.study.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 1.Lambda表达式的基础语法：Java8中引入了一个新的操作符“>”,
 *  该操作符为箭头操作符或Lamdba操作符
 *  箭头操作符Lambda表达式拆分成两部分：
 *  左侧：Lambda表达式的参数列表
 *  右侧：Lambda表达式所需要执行的功能：即Lambda体
 *
 *  语法格式1：无参数，无返回值
 *        ()-> System.out.println("Hello Lambda!!!");
 *  语法格式2：有一个参数，无返回值
 *         (x)-> System.out.println(x)
 *  语法格式3：若只有一个参数，小括号可以省略不写
 *          x-> System.out.println(x)
 *
 *  语法格式4：有两个以上的参数，有返回值，并且Lambda体中有多条语句
 *         Comparator<Integer> com=(x,y)->{
 *             System.out.println("国庆第一天");
 *             return Integer.compare(x,y);
 *         };
 *  语法格式5：若Lambda体中只有一条语句，return和大括号都可以省略不写
 *  语法格式6：Lambda表达式的参数列表的数据可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 *
 *  上联：左右遇一括号省
 *  下联：左侧推断类型省
 *  横批：能省则省
 * 二：Lambda表达式需要“函数式”接口的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FuncionalInterface修饰
 *           可以检查是否式函数式接口
 *
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        int num=0;//jdk1.7 前，必须是final
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!!!"+num);
            }
        };
        runnable.run();
        System.out.println("---------------------------------");
        Runnable runnable1=()-> System.out.println("你好"+num);
        runnable1.run();
    }
    @Test
    public void test2(){
        Consumer<String> con=(x)-> System.out.println(x);
        con.accept("国庆快乐！！！");
    }
    @Test
    public void test3(){
        Comparator<Integer> com=(x,y)->{
            System.out.println("国庆第一天");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
        //语法格式5：若Lambda体中只有一条语句，return和大括号都可以省略不写
        Comparator<Integer> com=(x,y)->
             Integer.compare(x,y);
    }
    @Test
    public void test5(){
        //语法格式5：若Lambda体中只有一条语句，return和大括号都可以省略不写
        Comparator<Integer> com=(x,y)->
                Integer.compare(x,y);
    }
    //需求：对一个数进行运算
    @Test
    public void test6(){
        Integer operationNum = operation(100, x -> x + 50);
        System.out.println(operationNum);
        System.out.println(operation(200,y -> y*y));
    }
    public Integer operation(Integer num,MyFun mf){
        return mf.getNum(num);
    }
}
