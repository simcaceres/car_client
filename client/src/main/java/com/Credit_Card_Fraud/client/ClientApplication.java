package com.Credit_Card_Fraud.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Al dejar este método limpio, eliminamos el error en rojo.
        // Ahora la ingesta automática la maneja de forma ordenada tu TransaccionController.
        System.out.println("🚀 Pipeline de Fraude Bancario levantado con éxito.");
    }
}