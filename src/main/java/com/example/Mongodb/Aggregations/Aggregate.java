package com.example.Mongodb.Aggregations;

import com.example.Mongodb.Repository.modelRepo1.Model1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class Aggregate {
    private MongoTemplate mongoTemplate;


    public List<Model1> Aggregation() {
        AggregationOperation match = Aggregation.match(Criteria.where("field").is("value"));

        Aggregation aggregation = Aggregation.newAggregation(match);

        AggregationResults<Model1> results = mongoTemplate.aggregate(aggregation, "file",Model1.class);
        List<Model1> res =  results.getMappedResults();
        return res;
    }
}
