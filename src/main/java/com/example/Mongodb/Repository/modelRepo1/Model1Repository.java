package com.example.Mongodb.Repository.modelRepo1;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableMongoRepositories(mongoTemplateRef = "mongoTemplate1")
public interface Model1Repository  extends MongoRepository<Model1,String>, PagingAndSortingRepository<Model1,String> {


}

