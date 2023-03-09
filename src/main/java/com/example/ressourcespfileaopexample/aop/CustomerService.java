package com.example.ressourcespfileaopexample.aop;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    public String getCustomerById(String id) {
        // implementation to get customer by id
        return "Customer[username : name , mail : name@gmail.com ]";
    }
    public List<String> getAllCustomers() {
        // implementation to get all customers
        return List.of("Customer[username : name , mail : name@gmail.com ]"
                ,"Customer[username : name , mail : name@gmail.com ]"
                ,"Customer[username : name , mail : name@gmail.com ]"
                ,"Customer[username : name , mail : name@gmail.com ]"
                ,"Customer[username : name , mail : name@gmail.com ]"
                ,"Customer[username : name , mail : name@gmail.com ]");

    }
}