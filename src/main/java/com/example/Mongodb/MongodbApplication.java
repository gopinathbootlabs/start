package com.example.Mongodb;

import com.example.Mongodb.Repository.modelRepo1.Model1;
import com.example.Mongodb.Repository.modelRepo1.Model1Repository;
import com.example.Mongodb.Repository.modelRepo2.Model2;
import com.example.Mongodb.Repository.modelRepo2.Model2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication

@Configuration
@EnableSwagger2
@RestController
public class MongodbApplication {
	@Autowired
	private Model1Repository repository;
	@Autowired
	private Model2Repository repos;

	private MongoTemplate mongoTemplate;
	private RestTemplate restTemplate;


	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo")).build();
	}


	@PostMapping("/chatgpt")
	public ResponseEntity<String> chat(@RequestBody Test test )
	{
		String api_key="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";
		String url="https://api.openai.com/v1/completions";

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + api_key);
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		String requestBody = "{\"prompt\":\"" + test.text + "\", \"max_tokens\": 50,\"model\": \"davinci\"}";
		HttpEntity<String> entity = new HttpEntity<>(requestBody,headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		return response;
	}

	@PostMapping("/add-data")
	public String add(@RequestBody Model1 name )
	{
		repository.save(name);
		return "Submitted";
	}

	@GetMapping("/sample")
	public String gets()
	{
		return "hi";
	}

	@GetMapping("/get-data")

	public List<Model1> get()
	{
		return repository.findAll();
	}

	@GetMapping("/pagination-{pages}")

	public Page<Model1> getPagination(@PathVariable int pages)
	{
		Pageable pageable = PageRequest.of(pages,3,Sort.by(Sort.Order.asc(("id"))));
		Page<Model1> pagedResult = repository.findAll(pageable);

		System.out.println(pagedResult.getTotalPages());
		return pagedResult;
	}
	public List<Model1> aggregation()
	{
		AggregationOperation match = org.springframework.data.mongodb.core.aggregation.Aggregation.match(Criteria.where("department").is("IT"));

		org.springframework.data.mongodb.core.aggregation.Aggregation aggregation = Aggregation.newAggregation(match);

		AggregationResults<Model1> results = mongoTemplate.aggregate(aggregation, "file",Model1.class);
		return results.getMappedResults();
	}

	@PostMapping("/adddata")
	public String addsec(@RequestBody Model2 name )
	{
		repos.save(name);
		return "Submitted";
	}

	@GetMapping("/getdata")
	public List<Model2> getsec()
	{
		return repos.findAll();
	}

}
