package com.shijie.sb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ShiJie on 2018-11-13 21:46
 */
@Entity
public class User {

    @Id  // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增策略
    private Long id; // 实体唯一标识
    private String name;
    private String email;

    protected User() { // 无参构造设为protected,防止直接使用
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d,name='%s',email='%s']", id, name, email);
    }
}
