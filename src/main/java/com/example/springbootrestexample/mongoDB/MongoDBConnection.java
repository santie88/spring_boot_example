package com.example.springbootrestexample.mongoDB;

import com.example.springbootrestexample.models.Author;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.stereotype.Service;

@Service
public abstract class MongoDBConnection {

    private String dbName = "springDB";
    private MongoClient mongoClient;
    protected DB db;

    protected DBCollection getCollectionByName (String collectionName){
        this.mongoClient = new MongoClient();
        this.db = mongoClient.getDB(dbName);
        DBCollection collection = db.getCollection(collectionName);
        return collection;
    }
}
