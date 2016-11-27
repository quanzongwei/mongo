package com.lida.mongo.mongoDao;

import com.lida.mongo.entity.Person;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by DuLida on 2016/10/21.
 */
@Repository("personMongoImpl")
public class PersonMongoImpl implements PersonMongoDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Person> findAll() {
        return mongoTemplate.findAll(Person.class,"person");
    }

    @Override
    public void insertPerson(Person person) {
        mongoTemplate.insert(person,"person");
    }

    @Override
    public void removePerson(String userName) {
        mongoTemplate.remove(Query.query(where("name").is(userName)), "person");
    }

    @Override
    public void updatePerson() {
        mongoTemplate.updateMulti(Query.query(where("age").gt(3).lte(5)), Update.update("age", 3), "person");
    }

    @Override
    public List<Person> findForRequery(String userName) {
        return mongoTemplate.find(Query.query(where("name").is(userName)),Person.class);
    }

    public void func() {
        MongoOperations mongoOperations = mongoTemplate;
        System.out.println(mongoOperations.findOne(new Query(where("name").is("name0")), Person.class));

    }
}
