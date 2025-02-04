package com.example.elctrobackend.controller;

import com.example.elctrobackend.models.Product;
import com.example.elctrobackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // Methods to Store, Delete and Search for Products
    // Is accessed by the Frontend
    @PostMapping("/saveAll")
    public ResponseEntity<String> StoreProducts(@RequestBody List<Product> productList){
        productService.setProducts(productList);
        return ResponseEntity.ok("Products Have Been Saved Successfully");
    }
    @PostMapping("/save")
    public ResponseEntity<String> StoreProduct(@RequestBody Product product){
        productService.setProduct(product);
        return ResponseEntity.ok("Product Has Been Saved");
    }
    @GetMapping("/fetch")
    public List<Product> FetchProducts(){
        return productService.getProducts();
    }
    @DeleteMapping("/delete/{id}")
    public String RemoveProduct(@PathVariable String id){
        return productService.removeProduct(id);
    }
}
