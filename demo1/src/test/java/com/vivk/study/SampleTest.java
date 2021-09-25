package com.vivk.study;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.vivk.study.dao.UserDao;
import com.vivk.study.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testSelect(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userDao.selectList(null);
        //遍历每一条数据
        userList.forEach(System.out::println);
        System.out.println(userList);

    }
}
