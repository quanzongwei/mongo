package com.lida.mongo.entity;

/**
 * Created by quanzongwei(207127) on 2016/11/27 0027.
 */
public class People {
    private String id;
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
