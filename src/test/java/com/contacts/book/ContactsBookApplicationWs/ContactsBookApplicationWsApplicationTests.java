package com.contacts.book.ContactsBookApplicationWs;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactsBookApplicationWsApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Hello Testing");
	}

    int port=8080;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    public void testRetrieveContactByEmailId() {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/contact/email/ram@d.com"),  HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":\"5b8ff73f39cd482381cac922\",\"emailId\":\"ram@d.com\",\"firstName\":\"ram\",\"lastName\":\"kohali\"}";

        System.out.println(response.getBody());

        try {
            JSONAssert.assertEquals(expected, response.getBody(), false);
        }catch (JSONException e){
            System.out.println(e.getMessage());
        }

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }


}
