package com.example.springbootrestexample.logic;

import com.example.springbootrestexample.Runner;
import com.example.springbootrestexample.models.Author;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.skyscreamer.jsonassert.JSONAssert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Runner.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AuthorTest {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    private AuthorLogic authorLogic;

    @Test
    public void createAuthorPass() throws JSONException {
        authorLogic.createAuthor(new Author("a","b"));

        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);

        ResponseEntity<String> response = testRestTemplate.exchange(
                "http://localhost:8080/api/author/a",
                HttpMethod.GET, entity, String.class);

        String expected = "{ name: a, email: b}";

        assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void createAuthorFail() throws JSONException {
        authorLogic.createAuthor(new Author("a","b"));

        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);

        ResponseEntity<String> response = testRestTemplate.exchange(
                "http://localhost:8080/api/author/a",
                HttpMethod.GET, entity, String.class);

        String expected = "{ name: b, email: b}";

        assertEquals(expected, response.getBody(), false);
    }
}
