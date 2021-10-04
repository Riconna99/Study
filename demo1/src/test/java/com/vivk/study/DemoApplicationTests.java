package com.vivk.study;

import com.vivk.study.entity.User;
import com.vivk.study.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper
        //所以不填写就是无任何条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testInsert(){

        User user = new User();
        user.setName("Mary2");
        user.setAge(18);
        user.setEmail("55312@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result); //影响的行数
        System.out.println(user); //id自动回填
    }
    @Test
    public void testUpdateById(){

        User user = new User();
        user.setId(1L);
        user.setAge(88);

        int result = userMapper.updateById(user);
        System.out.println(result);
    }
}
