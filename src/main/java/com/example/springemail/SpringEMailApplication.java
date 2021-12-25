package com.example.springemail;

import com.example.springemail.sender.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEMailApplication {

    @Autowired
    private EmailSenderService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringEMailApplication.class, args);
    }
    //When application is ready EMail will be triggered
    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail(){
        service.sendSimpleEmail("kumarbalingal@gmail.com",
                "This is body",
                "This is subject");
    }
}
