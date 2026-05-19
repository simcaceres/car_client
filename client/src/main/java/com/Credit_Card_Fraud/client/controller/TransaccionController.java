package com.Credit_Card_Fraud.client.controller;

import com.Credit_Card_Fraud.client.service.TransaccionService;
import com.Credit_Card_Fraud.client.model.Transaccion;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransaccionController {

    private TransaccionService service;

    public TransaccionController(){
        this.service = new TransaccionService();
    }

    public void ejecutarIngestaCompleta(){
        System.out.println("[Controller] Solicitud de ingesta recibida.");

        service.iniciarPipeline();

        System.out.println("[Controller] Proceso de ingesta finalizado.");
    }

    public static void main(String[] args){
        TransaccionController controller = new TransaccionController();
        controller.ejecutarIngestaCompleta();
    }


}
