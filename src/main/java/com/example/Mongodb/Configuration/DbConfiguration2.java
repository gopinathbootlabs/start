package com.example.Mongodb.Configuration;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.Mongodb.Repository.modelRepo2",
        mongoTemplateRef = "mongoTemplate2")
public class DbConfiguration2 extends Configure {
        @Bean
    public MongoTemplate mongoTemplate2() {
        MongoClient mongoClient = createMongoClient("mongodb://localhost:27017");
        return createMongoTemplate(mongoClient, "demo2");
    }

}
