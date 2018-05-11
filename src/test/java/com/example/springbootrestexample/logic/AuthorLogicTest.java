package com.example.springbootrestexample.logic;

import com.example.springbootrestexample.configurations.AppConfig;
import com.example.springbootrestexample.configurations.AppConfigMemory;
import com.example.springbootrestexample.controllers.AuthorController;
import com.example.springbootrestexample.models.Author;
import com.example.springbootrestexample.repositories.AuthorRepository;
import com.example.springbootrestexample.repositories.AuthorRepositoryInMemory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorLogicTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorLogic authorLogic;

    //@Before
    //public void setup() {
    //    MockitoAnnotations.initMocks(this);
    //}

    @Test
    public void emptyList(){
        //GIVEN
        when(authorRepository.listAuthors()).thenReturn(Collections.emptyList());

        //WHEN
        List<Author> authors = authorLogic.getAllAuthors();

        //THEN
        Assert.assertEquals(authors, Collections.emptyList());
        verify(authorRepository, times(1)).listAuthors();
    }

    @Test
    public void testCreateAuthor(){
        //GIVEN
        Author author = new Author("s","a");

        when(authorRepository.createAuthor(author)).thenReturn(author);

        //WHEN
        Author authorCreated = authorLogic.createAuthor(author);

        //THEN
        Assert.assertEquals(authorCreated, author);
        verify(authorRepository, times(1)).createAuthor(author);
    }

    @Test
    public void creation(){
        //GIVEN
        Author author = new Author("s","a");

        //WHEN
        Author authorCreated = new AuthorLogic(new AuthorRepositoryInMemory()).createAuthor(author);

        //THEN
        Assert.assertEquals(authorCreated, author);
    }
}