package com.contacts.book.ContactsBookApplicationWs.Controllers;

import com.contacts.book.ContactsBookApplicationWs.Models.Person;
import com.contacts.book.ContactsBookApplicationWs.Repositories.PersonRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;

@RestController
public class PersonConroller {

    @Autowired
    private PersonRepository personrepository;

    @RequestMapping(value = "/contact/email/{emailid}", method = RequestMethod.GET)
    public Person getPersonContactByEmail(@PathVariable("emailid") String emailid){
        return personrepository.findByemailId(emailid);
    }

    @RequestMapping(value = "/contacts/{firstname}", method = RequestMethod.GET)
    public List<Person> getPersonContactByName(@PathVariable("firstname") String firstname){
        return personrepository.findByfirstName(firstname);
    }

    @RequestMapping(value = {"/contacts/search/{firstname}/{page}/{pagesize}", "/contacts/search/{firstname}" }, method = RequestMethod.GET)
    public List<Person> searchByName(@PathVariable("firstname") String firstname,
                                     @PathVariable(name = "page", required = false) Integer page,
                                     @PathVariable(name = "pagesize", required = false) Integer pagesize){

        List<Person> searchedPersons = personrepository.findByfirstName(firstname);

        if(searchedPersons.size() == 0){
            return null;
        }

        int defaultPageSize = 10;
        if(page == null) {
            int datalen = searchedPersons.size();
            if (defaultPageSize > datalen) {
                return searchedPersons.subList(0, datalen);
            }
            else{
                return searchedPersons.subList(0, defaultPageSize);
            }
        }
        else {
            if (pagesize <= 0 || page <= 0) {
                return null;
            } else {

                int start = (page - 1) * pagesize;
                int end = page * pagesize;
                int datalength = searchedPersons.size();

                if (start < end && end < datalength) {
                    return searchedPersons.subList(start, end);
                } else if (start < datalength) {
                    return searchedPersons.subList(start, datalength);
                }
            }
        }
        return null;
    }

    @RequestMapping(value = {"/contacts", "/contacts/"}, method = RequestMethod.GET)
    public List<Person> getAllContacts(){
        return personrepository.findAll();
    }

    @RequestMapping(value = "/contact/new", method = RequestMethod.POST)
    public Person createContact(@Valid @RequestBody Person person){
        try {
            personrepository.insert(person);
        }catch (DuplicateKeyException e){
            System.out.println(e.getMessage());
            return null;
        }
        return person;
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    public Person modifyContactById(@PathVariable("id") ObjectId id, @Valid @RequestBody Person person) {
        person.setId(id);
        try {
            personrepository.save(person);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return person;
    }

    @RequestMapping(value = "/contact/delete/{id}", method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable("id") ObjectId id){
        try {
            personrepository.deleteByid(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Failed";
        }
        return "Success";
    }

    @RequestMapping(value = "/contact/delete/one/{emailid}", method = RequestMethod.DELETE)
    public String deleteContactByEmailId(@PathVariable("emailid") String emailid){
        try {
            personrepository.deleteByemailId(emailid);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Failed";
        }
        return "Success";
    }

}