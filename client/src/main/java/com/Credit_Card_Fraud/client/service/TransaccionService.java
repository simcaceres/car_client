package com.Credit_Card_Fraud.client.service;

import com.Credit_Card_Fraud.client.repository.TransaccionRepository;

public class TransaccionService {

    private TransaccionRepository repository;

    public TransaccionService(){
        this.repository = new TransaccionRepository();
    }

    public void iniciarPipeline(){
        System.out.println("--- Service: Iniciando Fase de Ingesta ---");

        repository.ingestaDesdeCSV("data/raw/datos_fraude.csv");

        System.out.println("--- Service: Ingesta Completada con Exito ---");
    }


}
