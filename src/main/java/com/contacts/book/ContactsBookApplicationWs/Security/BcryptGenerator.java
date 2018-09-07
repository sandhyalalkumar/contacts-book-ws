package com.contacts.book.ContactsBookApplicationWs.Security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BcryptGenerator {

    static public PasswordEncoder passEncoder = new BCryptPasswordEncoder();

}
