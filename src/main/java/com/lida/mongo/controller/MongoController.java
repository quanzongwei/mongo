package com.lida.mongo.controller;

import com.lida.mongo.dao.PersonDao;
import com.lida.mongo.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by DuLida on 2016/10/20.
 */
@Controller
@RequestMapping(value = "/goMongo")
public class MongoController {

    @Autowired
    PersonDao personDao;

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String go() {
        return "mogoList";
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String go2() {
        // findALl
        System.out.println(personDao.findAll());

        return "mogoList";
    }

    @RequestMapping(value = "/findIdNameGe", method = RequestMethod.GET)
    public String go23() {
        System.out.println(personDao.findByAge2(1, 2, "name2"));

        return "mogoList";
    }

    @RequestMapping(value = "/listAllFields", method = RequestMethod.GET)
    public String go4() {
        System.out.println(personDao.findByAge2(1, 2, "name2"));
        return "mogoList";
    }

    @RequestMapping(value = "/between", method = RequestMethod.GET)
    public String go5() {
        System.out.println(personDao.findByAgeBetween(1, 3));
        return "mogoList";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String go6() {
        // System.out.println(personDao.findByName("name0"));
        System.out.println(personDao.findByName("name0", new PageRequest(0, 10, Sort.Direction.ASC, "_id")));

        return "mogoList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String go7() {
        // System.out.println(personDao.findByName("name0"));
        System.out.println(personDao.deleteByName("name9"));
        System.out.println(personDao.deletePersonByName("name8"));

        // 更新操作成功,保存就是更新了
        Person person = personDao.findOne(new ObjectId("5836dc7b793a34373068ff9c"));
        System.out.println(person);
        person.setAge(100);
        System.out.println(personDao.save(person));

        return "mogoList";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String go8() {

        // 查找一个
        System.out.println(mongoTemplate.findOne(new Query(where("name").is("name0")), Person.class));
        return "mogoList";
    }

}
