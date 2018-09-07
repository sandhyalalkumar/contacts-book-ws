package com.contacts.book.ContactsBookApplicationWs.Commons;

import com.contacts.book.ContactsBookApplicationWs.Repositories.UserRepository;
import com.contacts.book.ContactsBookApplicationWs.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class ApplicationDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationDataLoader.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //repository.deleteAll();

        repository.save(new User("Sai", "Chandra", "sai", "sai", new String[]{"ADMIN"}));
        repository.save(new User("Sandhyalal", "Gond", "sand", "sand", new String[]{"ADMIN", "USER"}));
        repository.save(new User("John", "Abraham", "john", "john", new String[]{"USER"}));
        repository.save(new User("Radhe", "Mohan", "radhe", "radhe", new String[]{"USER"}));
        repository.save(new User("Ram", "Prasad", "ram", "ram", new String[]{"USER"}));
        repository.save(new User("Krishna", "Kanth", "krishna", "krishna", new String[]{"USER"}));
        repository.save(new User("Siva", "Singh", "siva", "siva", new String[]{"ADMIN", "USER"}));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (User user : repository.findAll()) {
            System.out.println(user);
            System.out.println(user.getFirstName()+" "+user.getUsername());
        }
        System.out.println();

    }
}