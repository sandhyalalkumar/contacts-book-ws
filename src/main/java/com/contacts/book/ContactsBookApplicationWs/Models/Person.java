package com.contacts.book.ContactsBookApplicationWs.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "persons")
public class Person {

    @Id
    private ObjectId id;
    @Indexed(name="emailaddress", unique=true)
    private String emailId;
    private String firstName;
    private String lastName;

    public Person(){}

    public Person(String emailId, String firstName, String lastName) {
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
