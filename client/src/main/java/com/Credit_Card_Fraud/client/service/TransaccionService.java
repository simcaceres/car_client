package com.Credit_Card_Fraud.client.service;

import com.Credit_Card_Fraud.client.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    // 🌟 AGREGAMOS (String ruta) AQUÍ ARRIBA:
    public void iniciarPipeline(String ruta) {
        System.out.println("--- Service: Iniciando Fase de Ingesta ---");

        // Ahora usamos la variable 'ruta' que viene desde el controlador
        repository.ingestaDesdeCSV(ruta);

        System.out.println("--- Service: Ingesta Completada con Éxito ---");
    }
}