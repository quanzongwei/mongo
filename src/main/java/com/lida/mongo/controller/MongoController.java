package com.lida.mongo.controller;

import com.lida.mongo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DuLida on 2016/10/20.
 */
@Controller
@RequestMapping(value = "/goMongo")
public class MongoController {

    @Autowired
    PersonDao personDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String go() {
        return "mogoList";
    }


    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public String go2() {
        //findALl
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
//        System.out.println(personDao.findByName("name0"));
       System.out.println(personDao.findByName("name0", new PageRequest(0, 10, Sort.Direction.ASC,"_id")));
        return "mogoList";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String go7() {
//        System.out.println(personDao.findByName("name0"));
       System.out.println(personDao.deleteByName("name9"));
       System.out.println(personDao.deletePersonByName("name8"));

        return "mogoList";
    }

}
