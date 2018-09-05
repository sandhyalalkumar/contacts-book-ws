package com.contacts.book.ContactsBookApplicationWs.Repositories;

import com.contacts.book.ContactsBookApplicationWs.Models.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
    public Person findByemailId(String emailId);
    public List<Person> findByfirstName(String firstName);
    public List<Person> findBylastName(String lastName);
    public List<Person> findAll();
    public Person findByid(ObjectId id);
    public void deleteByid(ObjectId id);
    public void deleteByemailId(String emailId);
}
