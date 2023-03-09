package com.example.ressourcespfileaopexample.ressources;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/*
*
*
The NotifySender class is annotated with @Component to mark it as a Spring bean.

The @Value annotation is used to load the mail and SMS files from the classpath based on properties specified in the Spring environment.
The ${mail.file.path} and ${sms.file.path} placeholders will be replaced with the actual values of these properties at runtime.

To send() method takes a type parameter to indicate whether to send a mail or SMS.
It uses the readFile() method to load the content of the appropriate file into a string variable.

The readFile() method takes a Resource parameter representing the file to read.
It reads the content of the file line by line using a BufferedReader, and appends each line to a StringBuilder.
Finally, it returns the string content of the file.

To send() method prints the content of the file to the console using System.out.println().
*
* */


@Component
public class NotifySender {

    @Value("classpath:${sms.file.path}")
    private Resource smsFile;

    @Value("classpath:${mail.file.path}")
    private Resource mailFile;

    public void send(Template type) throws IOException {
        String content = "";
        if (Template.MAIL.equals(type)) {
            content = readFile(mailFile);
        } else if (Template.SMS.equals(type)) {
            content = readFile(smsFile);
        }
        System.out.println(content);
    }

    private String readFile(Resource file) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (InputStream inputStream = file.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }
}

