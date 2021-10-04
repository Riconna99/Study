package com.vivk.study.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;

}