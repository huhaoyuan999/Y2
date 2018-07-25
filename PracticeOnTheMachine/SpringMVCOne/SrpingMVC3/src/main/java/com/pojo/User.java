package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class User {
    private String name;//姓名

    private Integer age;//年龄

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss" ,
            timezone = "GMT+8")
    private Date dateBirth;//出生日期

    public User() {
    }

    public User(String name, Integer age, Date dateBirth) {
        this.name = name;
        this.age = age;
        this.dateBirth = dateBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dateBirth=" + dateBirth +
                '}';
    }

}
