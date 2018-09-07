package com.contacts.book.ContactsBookApplicationWs.Models;

import com.contacts.book.ContactsBookApplicationWs.Security.BcryptGenerator;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User{


    @Id private ObjectId id;
    private String firstName;
    private String lastName;
    @Indexed(name = "usernameindex", unique = true)
    private String username;
    private String password;
    private String[] roles;

    public User() {}

    public User(String firstName, String lastName, String username, String password, String[] roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = this.encodePassword(password);
        this.roles = roles;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = this.encodePassword(password);
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    private String encodePassword(String password){
        return BcryptGenerator.passEncoder.encode(password);
    }
}