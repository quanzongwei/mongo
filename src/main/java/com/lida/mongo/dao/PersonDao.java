package com.lida.mongo.dao;

import com.lida.mongo.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by DuLida on 2016/10/20.
 */
public interface PersonDao extends MongoRepository<Person, ObjectId> {

    //fields 可以理解为是只要这两个字段的数据,id还是会有的
    @Query(value = "{'age' : {'$gte' : ?0, '$lte' : ?1}, 'name':?2 }",fields="{ 'name' : 1, 'age' : 1}")
    List<Person> findByAge(int ageGTE, int ageLTE, String name);

    //查询满足天哦见的所有数据所有数据
    @Query(value = "{'age' : {'$gte' : ?0, '$lte' : ?1}, 'name':?2 }")
    List<Person> findByAge2(int ageGTE, int ageLTE, String name);

    //1和3只能取出2的数据,between 不包括边界值
    List<Person> findByAgeBetween(int lft, int rgt);

    //亲测可用这两个
    List<Person> findByName(String name, Pageable pageable);
    List<Person> findByName(String name);

    //删除 有两种返回形式 好
    List <Person> deleteByName(String name);

    Long deletePersonByName(String name);



}
