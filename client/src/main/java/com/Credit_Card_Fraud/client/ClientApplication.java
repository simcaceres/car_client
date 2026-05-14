package com.Credit_Card_Fraud.client;

import com.Credit_Card_Fraud.client.controller.TransaccionController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner init(TransaccionController controller){
        return  args -> {
            controller.ejecutarIngestaCompleta();
        };
    }

}
