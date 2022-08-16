package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 20312
 * @author 2022/8/16 8:42
 */
@Data
@Entity //这是实体类
@Table(name = "user") //对应哪张表
public class User {
    /**
     *
     */
    @Id //这是主键
    @Column(name = "id")//数据库中的id,对应属性中的id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    int id;
    /**
     *
     */
    @Column(name = "username")//数据库中的username,对应属性中的username
    String username;
    /**
     *
     */
    @Column(name = "password")//数据库中的password,对应属性中的password
    String password;

}

