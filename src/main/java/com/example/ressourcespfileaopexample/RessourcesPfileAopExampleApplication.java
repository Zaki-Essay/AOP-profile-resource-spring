package com.example.ressourcespfileaopexample;

import com.example.ressourcespfileaopexample.aop.CustomerService;
import com.example.ressourcespfileaopexample.aop.ProductService;
import com.example.ressourcespfileaopexample.profile.DataBaseConfig;
import com.example.ressourcespfileaopexample.ressources.NotifySender;
import com.example.ressourcespfileaopexample.ressources.Template;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
*


NullPointerException: If you are getting a NullPointerException, it means that your code is trying to access a null object.
* To fix this, you need to make sure that all the objects that your code depends on are properly initialized.

FileNotFoundException: If you are getting a FileNotFoundException,
* it means that your code is trying to access a file that does not exist.
* To fix this, you need to make sure that the file exists and is accessible by your code.

SQLException: If you are getting an SQLException, it means that there is a problem with your database connection or query.
* To fix this, you need to check your database connection settings and make sure that your query is correct.

IllegalStateException: If you are getting an IllegalStateException, it means that your code is in an invalid state.
* To fix this, you need to make sure that your code follows the correct sequence of operations.


* */
@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class RessourcesPfileAopExampleApplication implements CommandLineRunner {


    private  NotifySender notifySender;

    private CustomerService customerService;

    private ProductService productService;

    private DataBaseConfig dataBaseConfig;





    public static void main(String[] args) {
        SpringApplication.run(RessourcesPfileAopExampleApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        log.info("###the first example : execute send methode by passing");
        log.info("notify By Mail");
        notifySender.send(Template.MAIL);
        log.info("notify by SMS ");
        notifySender.send(Template.SMS);


        log.info("###the second example : AOP");
        //test login aspect
        customerService.getAllCustomers();
        customerService.getCustomerById("TEST");
        productService.getAllProducts();
        //test exception handling exception
        //productService.getProductById("TEST");

        log.info("###the third example : spring profile");
        log.info("the url used - " + dataBaseConfig.connect());











    }
}
