package com.lida.mongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by DuLida on 2016/10/20.
 */
@Document(collection="person")
//@Document(collection="#{ @orgProvider.getOrg()}_datadic") 可以使用已经注入的对象的方法,orgProvider是注入到spring的对象
public class Person implements Serializable {

    @Id
    private ObjectId id;
    private String name;
    private int age;
    private Address address;

    public Person() {
    }

    public Person( String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}'+"\n";
    }
}
