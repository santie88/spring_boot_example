package com.example.springbootrestexample.mongoDB;

import com.example.springbootrestexample.models.Author;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.stereotype.Service;

@Service
@Deprecated
public abstract class MongoDBConnection {

    private String dbName = "springDB";
    private MongoClient mongoClient;
    private DB db;

    protected DBCollection getCollectionByName (String collectionName){
        this.mongoClient = new MongoClient();
        this.db = mongoClient.getDB(dbName);
        return db.getCollection(collectionName);
    }
}
