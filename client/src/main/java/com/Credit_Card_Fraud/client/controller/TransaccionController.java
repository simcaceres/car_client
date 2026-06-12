package com.Credit_Card_Fraud.client.controller;

import com.Credit_Card_Fraud.client.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    // 🌟 DEJAMOS QUE SPRING INYECTE EL SERVICIO AUTOMÁTICAMENTE
    @Autowired
    private TransaccionService service;

    // 🚀 ESTE ENDPOINT ACTIVARÁ TU PIPELINE DESDE EL NAVEGADOR
    // Ejemplo de uso: http://localhost:8080/transacciones/ingesta?ruta=tu_ruta_al_csv.csv
    @GetMapping("/ingesta")
    public ResponseEntity<String> ejecutarIngestaCompleta(@RequestParam String ruta) {
        System.out.println("[Controller] Solicitud de ingesta recibida para la ruta: " + ruta);

        try {
            service.iniciarPipeline(ruta); // Asegúrate de que tu método reciba la ruta en el servicio
            System.out.println("[Controller] Proceso de ingesta finalizado.");
            return ResponseEntity.ok("✅ Ingesta completada con éxito en PostgreSQL.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("❌ Error en la ingesta: " + e.getMessage());
        }
    }
}