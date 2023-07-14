package com.example.Mongodb.Repository.modelRepo2;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="demo2")
@ToString
public class Model2 {

    @Id
    private Integer id;
    private String name;
    private String job;
}