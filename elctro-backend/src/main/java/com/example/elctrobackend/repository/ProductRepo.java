package com.example.elctrobackend.repository;

import com.example.elctrobackend.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ProductRepo extends ElasticsearchRepository<Product, String> {

}
