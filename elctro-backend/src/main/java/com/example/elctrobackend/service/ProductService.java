package com.example.elctrobackend.service;

import com.example.elctrobackend.models.Product;
import com.example.elctrobackend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){this.productRepo=productRepo;}
    // To Save Products
    public Iterable<Product> setProducts(List<Product> productList){
        try {
            return productRepo.saveAll(productList);
        }catch (Exception e){
            throw new RuntimeException("Error Saving the Product List: " +e.getMessage());
        }
    }
    public Product setProduct(Product product){
        try {
            return productRepo.save(product);
        }catch (Exception e){
            throw new RuntimeException("Error Saving the Product: " +e.getMessage());
        }
    }
    // To Fetch Products
    public List<Product> getProducts(){
        Pageable pageable = PageRequest.of(0,5);
        try{
            Page<Product> productPage = productRepo.findAll(pageable);
            return productPage.getContent();
        }catch (Exception e){
            throw new RuntimeException("Couldn't load Products "+e.getMessage());
        }
    }
    // To Remove Products
    public String removeProduct(String id){
        try{
        if(productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "Product Has Been Deleted Successfully "+productRepo.findById(id).get().getModel();
        }else {
            return "Product ID: "+id+" doesn't exist";
        }}catch (Exception e){
            throw new RuntimeException("Error Removing Product "+e.getMessage());
        }
    }
}
