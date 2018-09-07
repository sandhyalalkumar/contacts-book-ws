package com.contacts.book.ContactsBookApplicationWs.Controllers;

import com.contacts.book.ContactsBookApplicationWs.Models.User;
import com.contacts.book.ContactsBookApplicationWs.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userrepository;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public User createContact(@Valid @RequestBody User user){
        try {
            userrepository.insert(user);
        }catch (DuplicateKeyException e){
            System.out.println(e.getMessage());
            return null;
        }
        return user;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello, I am there!!";
    }

}