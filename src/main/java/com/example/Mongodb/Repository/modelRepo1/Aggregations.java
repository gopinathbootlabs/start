//package com.example.Mongodb.Repository.modelRepo1;
//
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.Aggregation;
//import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
//import org.springframework.data.mongodb.core.aggregation.AggregationResults;
//import org.springframework.data.mongodb.core.query.Criteria;
//
//import java.util.List;
//
//public class Aggregations implements Define{
//    private MongoTemplate mongoTemplate;
//    public List<Model1> Aggregate()
//    {
//
//        AggregationOperation match = org.springframework.data.mongodb.core.aggregation.Aggregation.match(Criteria.where("department").is("It"));
//
//        Aggregation aggregation = org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation(match);
//
//        AggregationResults<Model1> results = mongoTemplate.aggregate(aggregation, "file",Model1.class);
//        List<Model1> res =  results.getMappedResults();
//        return res;
//    }
//}
