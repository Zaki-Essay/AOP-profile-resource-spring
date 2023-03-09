package com.example.ressourcespfileaopexample.aop;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    public String getProductById(String id) {
        // implementation to get product by id
        throw new RuntimeException("hello from Runtime Exception");

    }
    
    
    public List<String> getAllProducts() {
        // implementation to get all products
        return List.of("Product[username : LQSDJNFLNJKLDJFN , PRICE : $12343 ]"
                ,"Product[username : LQSDJNFLNJKLDJFN , PRICE : $12343 ]"
                ,"Product[username : LQSDJNFLNJKLDJFN , PRICE : $12343 ]"
                ,"Product[username : LQSDJNFLNJKLDJFN , PRICE : $12343 ]"
                ,"Product[username : LQSDJNFLNJKLDJFN , PRICE : $12343 ]"
                ,"Product[username : LQSDJNFLNJKLDJFN , PRICE : $12343 ]");
    }
    
    
}