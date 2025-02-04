package com.example.elctrobackend.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.elasticsearch.annotations.Document;
import org.yaml.snakeyaml.events.Event;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
public class Product {
    @Id

    private String id;
    private String name;
    private String brand;
    private String model;
    private double price;
    private boolean availability;
    private int stock;
    private Map<String, Object> specs;
    /*
    Sample Product JSON:
    {
        "id": "1",
        "name": "Laptop",
        "brand": "Azus",
        "model": "Vivo Book",
        "price": 200000,
        "availability": true,
        "stock": 5,
        "specs": {
        "RAM": "16GB",
        "Processor": "Intel Core i7",
        "Storage": "512GB SSD"
           }
    }
     */
}

