package com.example.Mongodb.Configuration;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.Mongodb.Repository.modelRepo1",
        mongoTemplateRef = "mongoTemplate1")
public class DbConfiguration1 extends Configure{
    @Bean
    @Primary
    public MongoTemplate mongoTemplate1() {
        MongoClient mongoClient = createMongoClient("mongodb://localhost:27017");
        return createMongoTemplate(mongoClient, "demo1");
    }

}


