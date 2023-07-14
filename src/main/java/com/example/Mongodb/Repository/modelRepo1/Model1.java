package com.example.Mongodb.Repository.modelRepo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="file")
@ToString
public class Model1 {

    @Id
    private Integer id;
    private String name;
    private String department;
    private Integer mark;
}