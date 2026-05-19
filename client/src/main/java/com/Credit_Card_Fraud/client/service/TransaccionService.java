package com.Credit_Card_Fraud.client.service;

import com.Credit_Card_Fraud.client.repository.TransaccionRepository;
import com.Credit_Card_Fraud.client.model.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository repository;


    public void iniciarPipeline(){
        System.out.println("--- Service: Iniciando Fase de Ingesta ---");

        repository.ingestaDesdeCSV("data/raw/datos_fraude.csv");

        System.out.println("--- Service: Ingesta Completada con Exito ---");
    }


}
