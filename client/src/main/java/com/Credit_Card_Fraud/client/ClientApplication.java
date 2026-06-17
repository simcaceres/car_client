package com.Credit_Card_Fraud.client;

import com.Credit_Card_Fraud.client.controller.TransaccionController;
import com.Credit_Card_Fraud.client.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private TransaccionService service;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 🌟 EL CAMBIO: Ponle la ruta adentro de los paréntesis para que no vaya vacío
        service.iniciarPipeline("data/raw/datos_fraude.csv");
    }

}
