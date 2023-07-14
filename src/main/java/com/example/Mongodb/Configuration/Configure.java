package com.example.Mongodb.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;

public class Configure extends ConfigureAbstract{

    protected MongoClient createMongoClient(String uri){
        return MongoClients.create(uri);
    }

    protected MongoTemplate createMongoTemplate(MongoClient mongoClient, String databaseName){
        return new MongoTemplate(mongoClient, databaseName);
    }
}
