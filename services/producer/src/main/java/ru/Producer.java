package ru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class Producer {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Producer.class);
        application.addListeners(new ApplicationPidFileWriter("./producer.pid"));
        application.run();
    }
}