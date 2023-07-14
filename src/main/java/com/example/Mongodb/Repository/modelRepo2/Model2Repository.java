package com.example.Mongodb.Repository.modelRepo2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories(mongoTemplateRef = "mongoTemplate2")
public interface Model2Repository extends MongoRepository<Model2, Integer> {
}
