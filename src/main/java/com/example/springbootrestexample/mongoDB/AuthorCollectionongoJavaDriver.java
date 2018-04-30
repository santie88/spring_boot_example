package com.example.springbootrestexample.mongoDB;

import com.example.springbootrestexample.models.Author;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorCollectionongoJavaDriver extends MongoDBConnection {

    private final String collectionName = "authors";
    private DBCollection collection = getCollectionByName(collectionName);

    public void insertAuthor(Author author){
        BasicDBObject document = new BasicDBObject();
        document.put("name", author.getName());
        document.put("email", author.getEmail());
        collection.insert(document);
    }

    public List<Author> findAll(){
        return convertCursorToList(collection.find());
    }

    public Author findOneByName(String name){
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", name);

        return convertObjectToAuhtor(collection.findOne(searchQuery));
    }

    private List<Author> convertCursorToList(DBCursor cursor){
        List<Author> authors = new ArrayList<>();

        while (cursor.hasNext()) {
            DBObject currectCursor = cursor.next();
            authors.add(new Author(
                    currectCursor.get("name").toString(),
                    currectCursor.get("email").toString())
            );
        }

        return authors;
    }

    private Author convertObjectToAuhtor(DBObject object){
        Author author = new Author(
                object.get("name").toString(),
                object.get("email").toString());

        return author;
    }
}
