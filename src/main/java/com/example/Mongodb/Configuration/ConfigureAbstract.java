package com.example.Mongodb.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;

abstract class ConfigureAbstract {
    abstract MongoClient createMongoClient(String uri);
    abstract MongoTemplate createMongoTemplate(MongoClient mongoClient, String databaseName);

}

