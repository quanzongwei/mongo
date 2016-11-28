package com.lida.mongo;

import com.lida.mongo.entity.People;
import com.mongodb.Mongo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * Created by quanzongwei(207127) on 2016/11/27 0027.
 */
public class Run {
    private static final Log log = LogFactory.getLog(Run.class);

    public static void main(String[] args) throws Exception {

        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo(), "person"));

        People p = new People("Joe", 34);

        // Insert is used to initially store the object into the database.
        mongoOps.insert(p);
        log.info("Insert: " + p);

        // Find
        p = mongoOps.findById(p.getId(), People.class);
        log.info("Found: " + p);

        // Update
        mongoOps.updateFirst(query(where("name").is("Joe")), update("age", 35), People.class);
        p = mongoOps.findOne(query(where("name").is("Joe")), People.class);
        log.info("Updated: " + p);

        // Delete
        mongoOps.remove(p);


        // Check that deletion worked
        List<People> people =  mongoOps.findAll(People.class);
        log.info("Number of people = : " + people.size());


        mongoOps.dropCollection(People.class);
        Query query = Query.query(where("name").is("hello"));

    }
}
