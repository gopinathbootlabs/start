package com.example.Mongodb;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data

@NoArgsConstructor
@ToString

public class Chatresponse {
    private String modelResponse;

    public Chatresponse(String modelResponse) {
        this.modelResponse = modelResponse;
    }


}